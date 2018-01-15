package contests.hourrank25;

import java.util.Scanner;

public class CanConstruct {
	static String canConstruct(int[] a) {
        // Return "Yes" or "No" denoting whether you can construct the required number.
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		if (sum % 3 == 0) 
			return "Yes";
		else {
			//Sum all the digits
			long n = 0, resSum = 0;
			while (sum > 0) {
				n = sum % 10;
				sum = sum / 10;
				resSum += n;
			}
			if (resSum % 3 == 0) {
				return "Yes";
			}
		}
 		return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = canConstruct(a);
            System.out.println(result);
        }
        in.close();
    }
}

