package algorithms.arrayandlist.stack.monolithic;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 * 
 * @author qz
 *
 */
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();

		int i = 0, max = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		while (!stack.isEmpty()) {
			int t = stack.pop();
			max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		}

		return max;
	}
}
