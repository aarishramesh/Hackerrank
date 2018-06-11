package tutorials.ctci;

/**
 * 
 * Solution for https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 * 
 * @author polymath
 *
 */
public class CountInversions {

	static int inversions = 0;

	public static void main(String[] args) {
		int[] arr = {2,1,3,1,2};
		System.out.println(countInversions(arr));
	}

	// Complete the countInversions function below.
	static long countInversions(int[] arr) {
		mergeSort(arr);
		return inversions;
	}

	static int[] mergeSort(int[] arr) {
		if (arr.length == 1)
			return arr; 
		int mid = (arr.length) / 2;
		int[] arrA = new int[mid];
		int i = 0;
		for (i = 0; i < mid; i++) {
			arrA[i] = arr[i];
		}
		int[] arrB = new int[arr.length - mid];
		int j = 0;
		for (; i < arr.length ; i++,j++) {
			arrB[j] = arr[i];
		}
		arrA = mergeSort(arrA);
		arrB = mergeSort(arrB);
		return mergeUsingInsertionSort(arrA, arrB);
	}

	static int[] mergeUsingInsertionSort(int[] arrA, int[] arrB) {
		int[] result = new int[arrA.length + arrB.length];
		int i = 0;
		for (i = 0; i < arrA.length; i++) {
			result[i] = arrA[i];
		}
		int j = 0;
		for (;i < result.length; i++,j++) {
			result[i] = arrB[j];
		}

		int n = result.length;
		for (i=1; i<n; ++i)
		{
			int key = result[i];
			j = i-1;

			/* Move elements of arr[0..i-1], that are
                   greater than key, to one position ahead
                   of their current position */
			while (j>=0 && result[j] > key)
			{
				result[j+1] = result[j];
				j = j-1;
				inversions++;
			}
			result[j+1] = key;
		}
		return result;
	}

	static int[] merge(int[] arrA, int[] arrB) {
		int[] result = new int[arrA.length + arrB.length];
		int i = 0, j = 0, k = 0;

		while (i < arrA.length && j < arrB.length) {
			if (arrA[i] == arrB[j]) {
				result[k] = arrA[i];
				k++;
				result[k] = arrB[j];
				i++;j++;
			} else if (arrA[i] < arrB[j]) {
				result[k] = arrA[i];
				i++;
			} else {
				result[k] = arrB[j];
				j++;
				inversions++;
			}
			k++;
		}

		if (i < arrA.length) {
			for (int a = i; a < arrA.length; a++) {
				result[k] = arrA[a];
				k++;
			}
		} else {
			for (int a = j; a < arrB.length; a++) {
				result[k] = arrB[a];
				k++;
			}
		}
		return result;
	}
}

