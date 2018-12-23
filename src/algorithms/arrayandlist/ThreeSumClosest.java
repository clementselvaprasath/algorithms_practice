package algorithms.arrayandlist;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author qz
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) return 0;
       
    	int res = 0, dif = Integer.MAX_VALUE;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++) {
    		int sub = target - nums[i];
    		int a = i + 1, b = nums.length - 1;
    		while (a < b) {
    			int sum = nums[a] + nums[b];
    			if (sum == sub) {
    				return target;
    			} else if (sum < sub) {
    				a++;
    			} else {
    				b--;
    			}
    			if (dif > Math.abs(sub - sum)) {
    				dif = Math.abs(sub - sum);
    				res = nums[i] + sum;
    			}
    		}
    	}

    	return res;
    }
}
