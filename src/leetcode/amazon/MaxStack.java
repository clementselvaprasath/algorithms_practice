package leetcode.amazon;

import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 * @author qz
 *
 */
public class MaxStack {
	Stack<Integer> stack;
    Stack<Integer> max;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (max.isEmpty()) {
            max.push(x);
        } else {
            if (max.peek() <= x) {
                max.push(x);
            } else {
                max.push(max.peek());
            }
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) return -1;
        int res = stack.pop();
        max.pop();
        return res;
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int peekMax() {
        if (max.isEmpty()) return -1;
        return max.peek();
    }
    
    public int popMax() {
        if (max.isEmpty()) return -1;
        int res = max.peek();
        Stack<Integer> tmp = new Stack<>();
        while (stack.peek() != res) {
            tmp.push(stack.pop());
            max.pop();
        }
        stack.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        
        return res;
    }
}
