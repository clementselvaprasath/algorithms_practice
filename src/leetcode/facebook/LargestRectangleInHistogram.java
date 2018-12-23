package leetcode.facebook;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * @author qz
 *
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// pop at A[i] < A[top], area = A[top] * (i - 1 - A[top-1])
    // at the end of the array, pop all elements
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (stack.peek() != -1 && (i == n || heights[i] < heights[stack.peek()])) {
                int k = stack.pop();
                max = Math.max(max, heights[k] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        
        return max;
    }
}
