package leetcode.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding 
 * window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 * @author qz
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deq = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
        	while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
    			deq.pollLast();
    		}
    		deq.offer(i);
    		if (i >= k - 1) {
    			 ans[i - k + 1] = nums[deq.peekFirst()];
                 if (i - k + 1 == deq.peekFirst()) {
                     deq.pollFirst();
                 }
    		}
        }
        
        return ans;
    }
}
