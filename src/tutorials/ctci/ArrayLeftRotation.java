package tutorials.ctci;

import java.util.Scanner;

/**
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. 
 * For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3,4, 5, 1, 2].
 * 
 * @author polymath
 *
 */
public class ArrayLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        printRotatedArr(a, k);
        in.close();
    }
    
    static void printRotatedArr(int[] arr, int noOfRotations) {
        int[] resArr = new int[arr.length];
        int newIndex = 0;
        for (int i = 1; i <= arr.length; i++) {
            newIndex = ( i + arr.length - noOfRotations);
            if (newIndex > arr.length) {
                newIndex = newIndex % arr.length;
            }
            resArr[newIndex - 1] = arr[i - 1];
        }
        for (int i = 0; i < resArr.length; i++) {
            System.out.print(resArr[i] + " ");
        }
    }
}