package leetcode.facebook;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * @author qz
 *
 */
public class RangeSumQuery_Immutable {
	class NumArray {
	    int[] sums;
	    int m;
	        
	    public NumArray(int[] nums) {
	        m = nums.length;
	        sums = new int[m + 1];
	        for (int i = 1; i <= m; i++) {
	            sums[i] = sums[i - 1] + nums[i - 1];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	        return sums[j + 1] - sums[i];
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
}
