package intereviewprepkit.arrays;

import java.util.Map.Entry;
import java.util.TreeMap;

public class ArrayManipulation {
	static long arrayManipulation(int n, int[][] queries) {
		long maxSum = 0;
		if (n > 0 && queries != null && queries.length > 0) {
			TreeMap<Integer, Integer> arrMax = new TreeMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				arrMax.put(queries[i][0], arrMax.getOrDefault(queries[i][0], 0) + queries[i][2]);
				arrMax.put(queries[i][1] + 1, arrMax.getOrDefault(queries[i][1] + 1, 0) - queries[i][2]);
			}
			long sum = 0;
			for (Entry<Integer, Integer> entry : arrMax.entrySet()) {
				sum += entry.getValue();
				if (sum > maxSum)
					maxSum = sum;
			}
		}
 		return maxSum;
    }
	
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
		System.out.println(arrayManipulation(3, arr));
	}
}
