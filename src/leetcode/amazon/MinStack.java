package leetcode.amazon;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 * @author qz
 *
 */
public class MinStack {
	Stack<Integer> stack;
    Stack<Integer> mins;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty()) {
            mins.push(x);
        } else {
            if (x <= mins.peek()) {
                mins.push(x);
            } else {
                mins.push(mins.peek());
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
    
    public int popMin() {
    	if (mins.isEmpty()) return -1;
    	int res = mins.peek();
    	Stack<Integer> tmp = new Stack<>();
    	while (stack.peek() != res) {
    		tmp.push(stack.pop());
    		mins.pop();
    	}
    	stack.pop();
    	mins.pop();
    	while (!tmp.isEmpty()) {
    		push(tmp.pop());
    	}
    	return res;
    }
}
