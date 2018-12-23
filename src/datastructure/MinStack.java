package datastructure;

import java.util.Stack;
/*
 * Implement a stack with min() function, which will return the smallest
 * number in the stack. It should support push, pop and min operation all in
 * O(1) cost.
 * 
 * Notice min operation will never be called if there is no number in the
 * stack.
 * 
 * Example 
 * push(1) pop() // return 1 
 * push(2) push(3) min() // return 2
 * push(1) min() // return 1
 * 
 */
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (min.empty()) {
        	min.push(number);
        } else {
        	min.push(Math.min(min.peek(), number));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
    	min.pop();
    	return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min.peek();
    }
}
