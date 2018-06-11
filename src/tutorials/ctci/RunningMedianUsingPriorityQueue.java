package tutorials.ctci;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem using Java's in-built
 * 	priority queu
 * 
 * @author polymath
 */
public class RunningMedianUsingPriorityQueue {

	static PriorityQueue<Integer> lowerQueue = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> higherQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			float median = 0;
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int element = sc.nextInt();
				if (lowerQueue.size() == higherQueue.size()) {
					if (element < median) {
						higherQueue.add(element);
						median = higherQueue.peek();
					} else {
						lowerQueue.add(element);
						median = lowerQueue.peek();
					}
				} else if (higherQueue.size() > lowerQueue.size()) {
					if (element < median) {
						lowerQueue.add(higherQueue.poll());
						higherQueue.add(element);
					} else {
						lowerQueue.add(element);
					}
					median = (float) (higherQueue.peek() + lowerQueue.peek()) / 2;
				}  else {
					if (element < median) {
						higherQueue.add(element);
					} else {
						higherQueue.add(lowerQueue.poll());
						lowerQueue.add(element);
					}
					median = (float) (higherQueue.peek() + lowerQueue.peek()) / 2;
				}
				System.out.println(median);
			}
		} finally {
			if (sc != null)
				sc.close();
		}
	}
}
