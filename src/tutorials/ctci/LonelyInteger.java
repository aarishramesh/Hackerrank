package tutorials.ctci;

import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-lonely-integer/problem
 * 
 * @author polymath
 *
 */
public class LonelyInteger {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int bitVector = 0;
        for(int a_i=0; a_i < n; a_i++){
            int num = in.nextInt();
            bitVector ^= num; 
        }
        System.out.println(bitVector);
        in.close();
    }
}
