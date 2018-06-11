package tutorials.ctci;

import java.util.*;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 * 
 * @author polymath
 *
 */
public class FibinacciUsingRecursion {
    static int[] memoizedResults = null;
    
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memoizedResults[n - 1] != 0) {
            return memoizedResults[n - 1];
        }
        int result = fibonacci(n-1) + fibonacci(n-2);
        memoizedResults[n - 1] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memoizedResults = new int[n];
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
