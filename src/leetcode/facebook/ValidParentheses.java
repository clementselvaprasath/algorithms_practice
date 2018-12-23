package leetcode.facebook;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author qz
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
        String leftSet = "([{";
        
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (leftSet.contains(String.valueOf(c[i]))) {
                stack.push(c[i]);
            } else if (!stack.empty() && valid(stack.peek(), c[i])) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.empty();
    }
    private static boolean valid(char a, char b) {
        return a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}';
    }
}
