package tutorials.ctci;

import java.util.Scanner;

public class PrimalityTest {

	private static final Scanner scanner = new Scanner(System.in);

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
}

