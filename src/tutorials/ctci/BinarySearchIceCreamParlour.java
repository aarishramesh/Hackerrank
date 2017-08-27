package tutorials.ctci;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 2 3
1 4
4 5
29 46
11 56
4 5
40 46
16 35
55 74
7 9

 * @author aarishramesh
 *
 */
public class BinarySearchIceCreamParlour {

	private static Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in =  new Scanner(System.in);
			int t = in.nextInt();
			for(int a0 = 0; a0 < t; a0++) {
				int total = in.nextInt();
				int n = in.nextInt();
				List<Integer> list = new LinkedList<Integer>();

				for(int a_i=1; a_i <= n; a_i++) {
					int cost = in.nextInt();
					costMap.put(a_i, cost);
					list.add(cost);
				}

				list.sort(null);

				int numA = 0;
				int numB = 0;
				for (int i = 0; i < list.size(); i++) {
					numA = list.get(i);
					LinkedList<Integer> listWithElementRemoved = new LinkedList<Integer>(list);
					listWithElementRemoved.removeFirstOccurrence(numA);
					numB = total - numA;
					if (numB > 0) {
						boolean elementFound = binarySearch(listWithElementRemoved, 0, listWithElementRemoved.size() - 1, numB);
						if (elementFound) {
							break;
						}
					}
				}

				int iceCreamA = -1, iceCreamB = -1;
				boolean numAFound = false, numBFound = false;
				for (Entry<Integer, Integer> entry : costMap.entrySet()) {
					if (!numAFound && entry.getValue().equals(numA)) {
						iceCreamA = entry.getKey();
						numAFound = true;
						continue;
					}
					if (!numBFound && entry.getValue().equals(numB)) {
						iceCreamB = entry.getKey();
						numBFound = true;
						continue;
					}
					if (numAFound && numBFound) {
						break;
					}
				}
				if (numAFound && numBFound) {
					if (iceCreamA > iceCreamB) {
						System.out.println(iceCreamB + " " + iceCreamA);
					} else {
						System.out.println(iceCreamA + " " + iceCreamB);
					}
				} else {
					System.out.println("-1 -1");
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	} 

	private static boolean binarySearch(List<Integer> list, int left, int right, int element) {
		if (left <= right) {
			int mid = (left + right) / 2;
			int midElement = list.get(mid);
			if (midElement == element) {
				return true;
			} else if (element < midElement) {
				return binarySearch(list, left, mid -1, element);
			} else {
				return binarySearch(list, mid + 1, right, element);
			}
		}
		return false;
	}
}
