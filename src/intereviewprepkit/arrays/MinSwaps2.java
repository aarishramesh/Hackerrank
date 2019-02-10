package intereviewprepkit.arrays;

/**
 * 
 *https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class MinSwaps2 {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 4, 6, 7};
		System.out.println(minimumSwaps(arr));
	}
	
	static int minimumSwaps(int[] arr) {
		int minSwaps = 0;
		if (arr != null && arr.length > 0) { 
			int[] pos = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++)
				pos[arr[i]] = i;
			for (int i = 1; i <= arr.length; i++) {
				if (arr[i - 1] != i) {
					pos[arr[i - 1]] = pos[i];
					arr[pos[i]] = arr[i - 1];
					arr[i - 1] = i;
					minSwaps++;
				}
			}
		}
		return minSwaps;
	}
}
