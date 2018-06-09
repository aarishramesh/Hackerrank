package tutorials.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Find the length of minimum sub array with maximum degree in an array.
 * 
 * The degree of an array is the count of element with maximum frequency
 * 
 * @author aarishramesh
 *
 */
public class FindingMinSubArrayWithMaxDegree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(degreeOfArray(arr));
		sc.close();
	}

	static int degreeOfArray(int[] arr) {
		HashMap<Integer, Integer> numbersByDegree = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int degree = numbersByDegree.getOrDefault(arr[i], 0);
			numbersByDegree.put(arr[i], degree + 1);
		}
		List<Map.Entry<Integer, Integer>> sortedEntries = sortByValue(numbersByDegree);
		int maxDegree = sortedEntries.get(0).getValue();

		int[] degreeArr = new int[arr.length] ;
		int minSubArrayLength = arr.length;
		for (Map.Entry<Integer, Integer> entry : sortedEntries) {
			if (entry.getValue() < maxDegree) {
				break;
			}
			for (int i = 0; i < arr.length; i++) {
				if (entry.getKey() == arr[i]) {
					if (i - 1 >= 0)
						degreeArr[i] = degreeArr[i - 1] + 1;
					else
						degreeArr[i] = 1;
				} else {
					if (i - 1 >= 0)
						degreeArr[i] = degreeArr[i - 1];
				}
			}
			boolean startIndexFound = false, endIndexFound = false;
			int startIndex = 0, endIndex = 0;
			for (int i = 0; i < degreeArr.length; i++) {
				if (startIndexFound && endIndexFound)
					break;
				if (!startIndexFound && degreeArr[i] == 1) {
					startIndex = i;
					startIndexFound = true;
				}
				if (!endIndexFound && degreeArr[i] == entry.getValue()) {
					endIndex = i;
					endIndexFound = true;
				}
			}
			if ((endIndex - startIndex) < minSubArrayLength) {
				minSubArrayLength = endIndex - startIndex;
			}
			for (int i = 0; i < degreeArr.length; i++)
				degreeArr[i] = 0;
		}
		return minSubArrayLength + 1;
	}

	private static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> 
	sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo( o1.getValue() );
			}
		});
		return list;
	}
}
