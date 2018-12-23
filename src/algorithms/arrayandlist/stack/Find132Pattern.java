package algorithms.arrayandlist.stack;

import java.util.Stack;

/**
 * http://lintcode.com/en/problem/132-pattern/
 * 
 * @author qz
 *
 */
public class Find132Pattern {

	public boolean find132pattern(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3) return false;
        
        int n = nums.length;
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) min[i] = nums[i];
            else min[i] = Math.min(min[i - 1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= min[i]) continue;
            if (stack.empty()) {
                stack.push(nums[i]);
            } else {
                if (nums[i] > stack.peek()) {
                    return true;
                } else {
                    stack.pop();
                    stack.push(nums[i]);
                }
            }
        }
        
        return false;
    }
}
