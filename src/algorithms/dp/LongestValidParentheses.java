package algorithms.dp;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
 * is "()" Example 2:
 * 
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()"
 * 
 * @author qz
 *
 */
public class LongestValidParentheses {
	
	public static void main(String[] args) {
		LongestValidParentheses obj = new LongestValidParentheses();
		String s = "(()(((()";
		System.out.println(obj.longestValidParentheses_stack(s));
	}
	
	
	// dp
	public int longestValidParentheses_dp(String s) {
		if (s == null || s.isEmpty() || s.length() <= 1)
			return 0;
		char[] chars = s.toCharArray();
		int max = 0, n = chars.length;

		int[] dp = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			if (chars[i] == ')') {
				if (chars[i - 1] == '(') {
					dp[i] = 2;
					if (i > 1) {
						dp[i] += dp[i - 2];
					}
				} else {
					if (dp[i - 1] == 0)
						continue;
					if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
						dp[i] = dp[i - 1] + 2;
						if (i - dp[i - 1] - 2 >= 0) {
							dp[i] += dp[i - dp[i - 1] - 2];
						}
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
	
	// stack
	public int longestValidParentheses_stack(String s) {
		if (s == null || s.isEmpty() || s.length() <= 1) return 0;
    	char[] chars = s.toCharArray();
    	int max = 0, total = 0;

    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < chars.length; i++) {
    		char c = chars[i];
    		if (c == '(') {
    			stack.push(i);
    		} else {
    			if (stack.isEmpty()) {
    				total = 0;
    			} else {
    				int tmp = i - stack.pop() + 1;
    				if (stack.isEmpty()) {
    					total += tmp;
    					max = Math.max(max, total);
    				} else {
    					// partial result
    					max = Math.max(max, i - stack.peek());
    				}
    			}
    		}
    	}

    	return max;
    }
}
