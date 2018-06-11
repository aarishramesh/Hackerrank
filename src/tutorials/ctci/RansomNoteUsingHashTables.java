package tutorials.ctci;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * 
 * @author polymath
 *
 */
public class RansomNoteUsingHashTables {

    public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int m = in.nextInt();
			int n = in.nextInt();
			String magazine[] = new String[m];
			for(int magazine_i=0; magazine_i < m; magazine_i++){
				magazine[magazine_i] = in.next();
			}
			String ransom[] = new String[n];
			for(int ransom_i=0; ransom_i < n; ransom_i++){
				ransom[ransom_i] = in.next();
			}

			Hashtable<String, Integer> magazineWords = new Hashtable<String, Integer>();
			Hashtable<String, Integer> ransomWords = new Hashtable<String, Integer>();

			if (m < n) {
				System.out.println("No");
				return;
			}

			for (int i = 0; i < m; i++) {
				if (i < m) {
					if (magazineWords.containsKey(magazine[i])) {
						int count = magazineWords.get(magazine[i]);
						count += 1;
						magazineWords.put(magazine[i], count);
					} else {
						magazineWords.put(magazine[i], 1);
					}
				}

				if (i < n) {
					if (ransomWords.containsKey(ransom[i])) {
						int count = ransomWords.get(ransom[i]);
						count += 1;
						ransomWords.put(ransom[i], count);
					} else {
						ransomWords.put(ransom[i], 1);
					}
				}
			}

			boolean wordCanbeFormed = false;

			for (Entry<String, Integer> ransomEntry : ransomWords.entrySet()) {
				String ransomWord = ransomEntry.getKey();
				int ransomWordCount = ransomEntry.getValue();
				if (magazineWords.containsKey(ransomWord) &&
						magazineWords.get(ransomWord) >= ransomWordCount) {
					wordCanbeFormed = true;
					continue;
				}
                wordCanbeFormed = false;
				break;
			}

			if (wordCanbeFormed) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} finally {
			if (in != null)
				in.close();
		}
	}
}
