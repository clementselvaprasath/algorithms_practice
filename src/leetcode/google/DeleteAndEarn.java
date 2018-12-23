package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given an array nums of integers, you can perform operations on the array.
	 * 
	 * In each operation, you pick any nums[i] and delete it to earn nums[i]
	 * points. After, you must delete every element equal to nums[i] - 1 or
	 * nums[i] + 1.
	 * 
	 * You start with 0 points. Return the maximum number of points you can earn
	 * by applying such operations.
	 * 
	 * Example 1: 
	 * Input: nums = [3, 4, 2] 
	 * Output: 6 
	 * Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted. 
	 * Then, delete 2 to earn 2 points. 6 total points are earned. 
	 * 
	 * Example 2: 
	 * Input: nums = [2, 2, 3, 3, 3, 4] 
	 * Output: 9 
	 * Explanation: Delete 3 to earn 3 points, deleting both 2's
	 * and the 4. Then, delete 3 again to earn 3 points, and 3 again to earn 3
	 * points. 9 total points are earned. 
	 * 
	 * Note:
	 * The length of nums is at most 20000. Each element nums[i] is an integer
	 * in the range [1, 10000].
	 */
	
	public static int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] f = new int[max + 1];
        f[0] = 0;
        f[1] = 1 * map.getOrDefault(1, 0);
        for (int i = 2; i <= max; i++) {
     	    f[i] = Math.max(f[i - 1], f[i - 2] + i * map.getOrDefault(i, 0));
        }

        return f[max];
    }
}
