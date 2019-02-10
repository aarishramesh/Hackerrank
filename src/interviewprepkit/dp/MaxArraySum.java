package interviewprepkit.dp;

/**
 * https://www.hackerrank.com/challenges/max-array-sum/problem
 * 
 * @author polymath
 *
 */
public class MaxArraySum {
	static int maxSubsetSum(int[] arr) {
		int max = 0;
		if (arr != null && arr.length > 0 ) {
			int inc = arr[0], exc = 0;
			max = inc;
			for (int i = 1; i < arr.length; i++) {
				int newInc = Math.max(arr[i], arr[i] + exc);
				exc = Math.max(inc, exc);
				inc = newInc;
				if  (max < Math.max(inc, exc))
					max = Math.max(inc, exc);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, -7, 8, 10};
		System.out.println(maxSubsetSum(arr));
	}
}
