package leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 * @author qz
 *
 */
public class MaxSubarraySumEqualK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {1, -1, 5, -2, 3};
		System.out.println(maxSubArrayLen(n, 3));
	}

	public static int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
        int n = nums.length, sum = 0, res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k) ) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return res == Integer.MIN_VALUE? 0: res;
    }
}
