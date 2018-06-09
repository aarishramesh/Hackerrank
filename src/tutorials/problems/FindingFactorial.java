package tutorials.problems;

import java.math.BigInteger;
import java.util.Scanner;

public class FindingFactorial {
	  public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sc = new Scanner(System.in);
	        long n = sc.nextInt();
	        BigInteger factorial = new BigInteger("1");
	        while (n > 0) {
	            factorial = factorial.multiply(BigInteger.valueOf(n));
	            n = n -1;
	        }
	        System.out.println(factorial);
	        sc.close();
	    }
}
