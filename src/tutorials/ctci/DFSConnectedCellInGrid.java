package tutorials.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import tutorials.ctci.DFSConnectedCellInGrid.Graph.Node;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 * 
 * @author polymath
 *
 */
public class DFSConnectedCellInGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int columns = in.nextInt();
		int grid[][] = new int[rows][columns];
		for(int grid_i=0; grid_i < rows; grid_i++){
			for(int grid_j=0; grid_j < columns; grid_j++){
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		Graph graph = constructGraph(grid, rows, columns);
		//graph.printNodesWithAdjacencyList();
		graph.findMaxConnectedRegion();
		System.out.println(graph.maxConnectedRegion);
		in.close();
	}

	private static Graph constructGraph(int[][] grid, int rows, int columns) {
		Graph graph = new Graph();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] == 1) {
					int id = (row * columns) + column + 1;
					Node node = new Node(id);
					graph.nodesMap.put(id, node);
				}
			}
		}
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int nodeId = (row * columns) + column + 1;
				Node node = graph.nodesMap.get(nodeId);
				// Check if any of the adjacent nodes to the node exists
				if (node != null) {
					for (int newRow = row - 1; newRow < row + 2; newRow++) {
						if (newRow >= 0 && newRow < rows ) {
							for (int newColumn = column - 1; newColumn < column + 2; newColumn++) {
								if (newColumn >= 0 && newColumn < columns
										&& !(newRow == row && newColumn == column)) {
									nodeId = (newRow * columns) + newColumn + 1;
									if (graph.nodesMap.get(nodeId) != null) {
										Node adjacentNode = graph.nodesMap.get(nodeId);
										node.adjacencyList.add(adjacentNode);
									}
								}
							}
						}
					}
				}
			}
		}
		return graph;
	}

	static class Graph {
		private int maxConnectedRegion = 0; 
		Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();

		static class Node {
			int id;
			List<Node> adjacencyList = new ArrayList<Node>();

			Node(int id) {
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

		public void printNodesWithAdjacencyList() {
			for (Entry<Integer, Node> entry : nodesMap.entrySet()) {
				Integer nodeId = entry.getKey();
				List<Node> adjacencyList = entry.getValue().adjacencyList;
				StringBuilder builder = new StringBuilder();
				builder.append(nodeId + " -> ");
				for (Node adjNode: adjacencyList) {
					builder.append(adjNode.id + " ");
				}
				System.out.println(builder.toString());
			}
		}
		
		public void findMaxConnectedRegion() {
			HashSet<Integer> visitedNodes = new HashSet<Integer>();
			for (Entry<Integer, Node> entry : nodesMap.entrySet()) {
				if (!visitedNodes.contains(entry.getKey())) {
					int regionCount = doDfsForRegionCount(entry.getValue(), visitedNodes, 0);
					if (regionCount > maxConnectedRegion) {
						this.maxConnectedRegion = regionCount;
					}
				}
			}
		}
		
		private int doDfsForRegionCount(Node node, Set<Integer> visitedNodes, int regionCount) {
			if (!visitedNodes.contains(node.id)) {
				regionCount += 1;
				visitedNodes.add(node.id);
				for (Node currNode : node.adjacencyList) {
					regionCount = doDfsForRegionCount(currNode, visitedNodes, regionCount);
				}
			}
			return regionCount;
		}
	}
}