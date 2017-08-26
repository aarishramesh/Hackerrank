package tutorials.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFSShortestPathToAllNodes {

	private static int[] resultArr;
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int noOfTests = sc.nextInt();

			for (int i =0 ; i < noOfTests; i++) {
				int noOfNodes = sc.nextInt();
				resultArr = new int[noOfNodes + 1];
				
				// Construct graph
				Graph graph = new Graph();
				for (int k = 0; k < noOfNodes; k++) {
					Graph.Node node = new Graph.Node(k + 1);
					graph.reverseNodesMap.put(k + 1, node);                    
				}
				int noOfEdges = sc.nextInt();
				for (int j = 0; j < noOfEdges; j++) {
					int srcNodeNum = sc.nextInt();
					int destNodeNum = sc.nextInt();
					Graph.Node srcNode = graph.reverseNodesMap.get(srcNodeNum);
					Graph.Node destNode = graph.reverseNodesMap.get(destNodeNum);
					srcNode.adjacencyList.add(destNode);
					destNode.adjacencyList.add(srcNode);
				}
				int startingNode = sc.nextInt();
				graph.startingNode = graph.reverseNodesMap.get(startingNode);

				int weight = 6;
				findShortestDistance(graph.startingNode, weight);

				StringBuilder builder = new StringBuilder();
				for (int n = 1; n <= noOfNodes; n++) {
					if (n != startingNode) {
						if (resultArr[n] == 0)
							resultArr[n] = -1;
						builder.append(resultArr[n]);
						if (n != noOfNodes)
							builder.append(" ");
					}
				}
				System.out.println(builder.toString());
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static class Graph {
		Map<Integer, Node> reverseNodesMap = new HashMap<Integer, Node>();
		Node startingNode;

		public static class Node {
			int id;
			List<Node> adjacencyList = new ArrayList<Node>();

			public Node(int id) {
				this.id = id;
			}

			@Override
			public boolean equals(Object node) {
				if (node != null) {
					if (this == node) {
						return true; 
					} else {
						if (node instanceof Node) {
							Node nodeIns = (Node) node;
							if (nodeIns.id == this.id) {
								return true;
							}
						}
					}
				}
				return false;
			}

			@Override
			public int hashCode() {
				return id;
			}
		}
	}
	
	private static void findShortestDistance(Graph.Node startingNode, int weight) {
		List<Graph.Node> bfsQueue = new ArrayList<Graph.Node>();
		bfsQueue.add(startingNode);
		while(!bfsQueue.isEmpty()) {
			Graph.Node node = bfsQueue.remove(0);
			for(Graph.Node child : node.adjacencyList) {
				if (child.id != startingNode.id && resultArr[child.id] == 0) {
					resultArr[child.id] = weight + resultArr[node.id];
					bfsQueue.add(child);
				}
			}
		}
	} 
}
