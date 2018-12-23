package leetcode.google;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 * 
 * @author qz
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        int n = nums.length;
        for (i = 0; i < n; i++) {
            if (j >= n) break;
            if (nums[j] == 0) {
                while (j < n && nums[j] == 0) {
                    j++;
                }
                if (j < n) swap(nums, i, j);
            } else {
                j = i + 1;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
