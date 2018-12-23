package algorithms.arrayandlist;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 * @author qz
 *
 */
public class BasicCalculator_I {
	
	
	// using stack
	public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		num = num * 10 + (c - '0');
        	} else if (c == '+' || c == '-') {
        		res += num * sign;
        		num = 0;
        		sign = c == '+'? 1 : -1;
        	} else if (c == '(') {
        		stack.push(res);
        		stack.push(sign);
        		res = 0;
        		sign = 1;
        	} else if (c == ')') {
        		res += num * sign;
        		res = res * stack.pop() + stack.pop();
        		sign = 1;
        		num = 0;
        	}
        }
        if (num != 0) res += num * sign;
        return res;
    }
}
