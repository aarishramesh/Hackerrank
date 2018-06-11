package tutorials.ctci;

import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-coin-change/problem
 * 
 * @author polymath
 *
 */
public class DPCoinChangeWays {

    	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int n = in.nextInt();
			int m = in.nextInt();
			int coins[] = new int[m];
			for(int coins_i=0; coins_i < m; coins_i++){
				coins[coins_i] = in.nextInt();
			}
			long noOfWays = noOfWaysOfChangeGeneration(n, coins);
			System.out.println(noOfWays);
		} finally {
			in.close();
		}
	}
	
	/**
	 * Logic for excluding and including the coin
	 * 
	 * @param n
	 * @param coins
	 * @return
	 */
	static long noOfWaysOfChangeGeneration(int n, int[] coins) {
		long[] coinChangesCount = new long[n + 1];
		coinChangesCount[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j - coins[i] >= 0) {
					coinChangesCount[j] += coinChangesCount[j - coins[i]];
				}
			}
		}
		return coinChangesCount[n];
	}
}
