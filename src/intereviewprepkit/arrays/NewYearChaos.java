package intereviewprepkit.arrays;

/**
 * 
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 * 
 * @author polymath
 *
 */
public class NewYearChaos {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 3, 7, 8, 6, 4};
		minimumBribes(arr);
	}
	
	static void minimumBribes(int[] q) {
		if (q != null && q.length != 0) {
			if (q.length == 1) {
				System.out.println(1);
				return;
			}
			int count = 0;
			for (int i = q.length - 1; i >= 0; i--) {
				if (q[i] != i + 1) {
					if (i - 1 >= 0 && q[i - 1] == i + 1) {
						swap(q, i - 1, i);
						count++;
					} else if (i - 2 >= 0 && q[i - 2] == i + 1) {
						count+=2;
						q[i - 2] = q[i - 1];
						q[i - 1] = q[i];
						q[i] = i + 1;
					} else {
						System.out.println("Too chaotic");
						return;
					}
				} 
				
			}
			System.out.println(count);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
