package tutorials.ctci;

import java.util.Scanner;

/**
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:

   Array is sorted in numSwaps swaps., where  is the number of swaps that took place. 
   First Element: firstElement, where  is the first element in the sorted array.
   Last Element: lastElement, where  is the last element in the sorted array.
 * 
 * @author polymath
 *
 */
public class CountBubbleSortSwap {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a, int n) {
        int swaps = 0;
    for (int i = 0; i < n; i++) { 
        for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            int temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
            swaps++;
        }
    }
    }
    System.out.println("Array is sorted in " + swaps + " swaps.");  
    System.out.println("First Element: " + a[0]); 
    System.out.println("Last Element: " + a[n - 1]);  
    }

    static void swap(int[] arr, int a, int b) {
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a, n);

        scanner.close();
    }
}