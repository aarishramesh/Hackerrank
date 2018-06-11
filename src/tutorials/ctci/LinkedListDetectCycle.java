package tutorials.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 * 
 * @author polymath
 *
 */
public class LinkedListDetectCycle {

	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(Node head) {
		List<Node> visitedNodes = new ArrayList<Node>();
		if (head != null) {
			while (head.next != null) {
				head = head.next;
				if (visitedNodes.contains(head)) {
					return true;
				} else {
					visitedNodes.add(head);
				}
			}
		}
		return false;
	}

}
