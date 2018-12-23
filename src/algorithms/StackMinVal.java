package algorithms;

import java.util.Stack;

public class StackMinVal {
	int minEle;
	Stack<Integer> s;

	/* returns min element from stack */
	int getMin() {
		return minEle;
	}

	/* returns poped element from stack */
	int pop() {
		if (s == null || s.isEmpty())
			return -1;
		int v = s.pop();
		if (s.isEmpty())
			return -1;
		if (v == minEle) {
			int min = Integer.MAX_VALUE;
			Stack<Integer> temp = new Stack<Integer>();
			while (!s.isEmpty()) {
				int e = s.pop();
				if (e < min) {
					min = e;
				}
				temp.push(e);
			}
			minEle = min;
			while (!temp.isEmpty()) {
				s.push(temp.pop());
			}
		}
		return v;
	}

	/* push element x into the stack */
	void push(int x) {
		if (s == null) {
			s = new Stack<Integer>();
			minEle = Integer.MAX_VALUE;
		}
		if (x < minEle) {
			minEle = x;
		}
		s.push(x);
	}
	
	public static void main(String[] args) {
		StackMinVal stack = new StackMinVal();
		
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		stack.push(1);
		System.out.println(stack.getMin());
	}
}
