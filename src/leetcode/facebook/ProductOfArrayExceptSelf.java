package leetcode.facebook;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * 
 * @author qz
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = nums[0];
		for (int i = 1; i < n; i++) {
			res[i] = nums[i] * res[i - 1];
		}
		int prev = 1;
		for (int i = n - 1; i > 0; i--) {
			res[i] = res[i - 1] * prev;
			prev *= nums[i];
		}

		res[0] = prev;
		return res;
	}
}
