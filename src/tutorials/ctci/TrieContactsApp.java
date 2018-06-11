package tutorials.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TrieContactsApp {
   private static class Node {
		HashMap<Character, Node> characterMap = new HashMap<Character, Node>();
		//boolean isCompleteWord = false;
		int count = 1;
	}

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			Node root = new Node();
			int n = in.nextInt();
			ArrayList<Integer> resArr = new ArrayList<Integer>();
			for(int a0 = 0; a0 < n; a0++){
				String op = in.next();
				String contact = in.next();
				if (op.equals("add")) {
					addContact(contact, root);
				} else if (op.equals("find")) {
					resArr.add(findMatchingContactsCount(contact, root));
				}
			}
			for (int i = 0; i < resArr.size(); i++) {
				System.out.println(resArr.get(i));
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private static void addContact(String contact, Node root) {
		for (int i = 0; i < contact.length(); i++) {
			char a = contact.charAt(i);
			HashMap<Character, Node> charMap = root.characterMap;
			if (charMap.containsKey(a)) {
				root = charMap.get(a);
				root.count++;
			} else {
				charMap.put(a, new Node());
				root = charMap.get(a);
			}
		}
		//root.isCompleteWord = true;
	}

	private static int findMatchingContactsCount(String contact, Node root) {
		for (int i = 0; i < contact.length(); i++) {
			char a = contact.charAt(i);
			HashMap<Character, Node> charMap = root.characterMap;
			if (charMap.containsKey(a)) {
				root = charMap.get(a);
				continue;
			} else {
				return 0;
			}
		}
		return root.count;
	}
}
