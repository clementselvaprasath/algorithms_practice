package leetcode.facebook;

/**
 * 
 * Minimum Size Subarray Sum Given an array of n positive integers and a
 * positive integer s, find the minimal length of a contiguous subarray of which
 * the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * 
 * 
 * @author qz
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (sum < s && j < nums.length) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                res = Math.min(res, j - i);
            }
            sum -= nums[i];
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}
