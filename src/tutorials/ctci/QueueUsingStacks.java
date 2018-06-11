package tutorials.ctci;

import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 * 
 * @author polymath
 *
 */
public class QueueUsingStacks {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

	public static class Queue<T> {
		Stack<T> stackA = new Stack<T>();
		Stack<T> stackB = new Stack<T>();

		void enqueue(T element) {
			stackA.push(element);
		}

		T dequeue() {
			if (stackB.isEmpty()) {
				while (!stackA.isEmpty()) {
					stackB.push(stackA.pop());
				}
			} 
			return stackB.pop();
		}

		T peek() {
			if (stackB.isEmpty()) {
				while (!stackA.isEmpty()) {
					stackB.push(stackA.pop());
				}
			} 
			return stackB.peek();
		}
	}

	public static class Stack<T> {
		Node<T> head;

		void push(T element) {
			Node<T> elementNode = new Node<T>(element);
			if(head == null) {
				this.head = elementNode;
			} else {
				elementNode.next = head;
				head = elementNode;
			}
		}

		T pop() {
			if (head != null) {
				T element = head.element;
				head = head.next;
				return element;
			}
			return null;
		}

		T peek() {
			if (head != null) {
				return head.element;
			}
			return null;
		}

		boolean isEmpty() {
			if (head == null) {
				return true;
			}
			return false;
		}
	}

	public static class Node<T> {
		T element;
		Node<T> next;

		Node(T element) {
			this.element = element;
		}
	}
}