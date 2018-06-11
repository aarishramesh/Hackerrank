package tutorials.ctci;

import java.util.Scanner;

public class PrimalityTest {

	private static final Scanner scanner = new Scanner(System.in);

	// Using 6k+-1 rule for prime numbers
	public static void main(String[] args) {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int pItr = 0; pItr < p; pItr++) {
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			if (n <= 1) {
				System.out.println("Not prime");
				continue;
			}
			if (n <= 3) {
				System.out.println("Prime");
				continue;
			}
			if (n % 2 == 0 || n % 3 == 0) {
				System.out.println("Not prime");
				continue;
			}
			for (int i = 5; i * i <= n; i = i + 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					System.out.println("Not prime");
					continue;
				}
			}
			System.out.println("Prime");
		}

		scanner.close();
	}
	
	// Checking until square root of n because multiple of sq-rt of a number is not a prime number so
	// 	it's sufficient to check for whether sq-rt of a number is a prime number
	static boolean isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}

