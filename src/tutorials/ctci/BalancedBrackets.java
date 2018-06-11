package tutorials.ctci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
 * 
 * @author polymath
 *
 */
public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
	        if (expression == null || expression.isEmpty()) {
	            return false;
	        }
	        List<Character> bracketStack = new ArrayList<Character>();
	        for(int i = 0; i < expression.length(); i++) {
	            char bracket = expression.charAt(i);
	            if (bracket == '{' || bracket == '[' || bracket == '(') {
	                bracketStack.add(bracket);
	            } else if (bracket == '}' || bracket == ']' || bracket == ')') {
                    if (bracketStack.isEmpty()) {
                        return false;
                    }
	                char prevBracket = bracketStack.get(bracketStack.size() - 1);
	                if ((prevBracket == '{' && bracket == '}') || 
                       (prevBracket == '(' && bracket == ')') ||
                       (prevBracket == '[' && bracket == ']')) {
	                    bracketStack.remove(bracketStack.size() - 1);
	                    continue;
	                } else {
	                    return false;
	                }
	            } else {
	                return false;
	            }
	        }
	        if (bracketStack.isEmpty()) {
                return true;
            } else {
                return false;
            }
	    }
	  
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for (int a0 = 0; a0 < t; a0++) {
	            String expression = in.next();
	            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
	        }
	        in.close();
	    }
}
