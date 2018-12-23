package leetcode.google;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author qz
 *
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                if (stack.isEmpty()) return 0;
                int b = stack.pop();
                if (stack.isEmpty()) return 0;
                int a = stack.pop();
                int val = calculate(a, b, token);
                stack.push(val);
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (Exception e) {
                    return 0;
                }
            }
        }
        
        return stack.isEmpty()? 0 : stack.pop();
    }
    
    private int calculate(int a, int b, String op) {
        if ("+".equals(op)) return a + b;
        if ("-".equals(op)) return a - b;
        if ("*".equals(op)) return a * b;
        if ("/".equals(op)) return a / b;
        return 0;
    }
}
