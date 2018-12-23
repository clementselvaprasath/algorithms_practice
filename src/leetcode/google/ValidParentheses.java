package leetcode.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * Example The brackets must close in the correct order, "()" and "()[]{}"
	 * are all valid but "(]" and "([)]" are not.
	 */
	public static boolean isValidParentheses(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if ("([{".contains(String.valueOf(c))) {
				stack.push(c);
			} else {
				if (!stack.empty() && isValid(stack.peek(), c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.empty();
	}
	
	
	private static boolean isValid(Character peek, Character c) {
		return peek == '(' && c == ')'
				|| peek == '[' && c == ']'
				|| peek == '{' && c == '}';
	}

	public static boolean isValidParentheses_MY(String s) {
		if (s == null || s.length() == 0) return false;

        Map<Character, Character> matcher = new HashMap<>();
        matcher.put(')', '(');
        matcher.put(']', '[');
        matcher.put('}', '{');
        
        char[] c = s.toCharArray();
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        for (int i = 0; i < c.length; i++) {
        	s1.push(c[i]);
        }

        while (!s1.empty()) {
        	Character p = s1.pop();
        	if (s2.empty()) {
        		s2.push(p);
        		continue;
        	}
        	Character q = matcher.get(s2.peek());
        	if (q == null || !q.equals(p)) {
        		s2.push(p);
        	} else {
        		s2.pop();
        	}
        }

        return s2.empty();
	}
}
