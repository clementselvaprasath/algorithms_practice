package leetcode.amazon;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 * @author qz
 *
 */
public class RotateArray {
	
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] n = {1,2,3,4,5,6,7};
		int k = 3;
		ra.rotate_2(n, k);
	}
	
	public void rotate_2(int[] nums, int k) {
        int m = nums.length;
        k = k % m;
        reverse(nums, 0, m - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, m - 1);
    }

    private void reverse(int[] nums, int i, int j) {
    	while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
	
	
	public void rotate_1(int[] nums, int k) {
        if (k == 0) return;

        int m = nums.length;
        for (int i = 0; i < k; i++) {
        	int tmp = nums[m - 1];
        	for (int j = m - 1; j > 0; j--) {
        		nums[j] = nums[j - 1];
        	}
        	nums[0] = tmp;
        }
    }
}
