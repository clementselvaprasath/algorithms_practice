package leetcode.google;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given an unsorted array nums, reorder it in-place such that
	 * 
	 * nums[0] <= nums[1] >= nums[2] <= nums[3].... Notice Please complete the
	 * problem in-place.
	 * 
	 * Example Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2,
	 * 5, 3, 4].
	 */
	
	public void wiggleSort(int[] nums) {
        // write your code here
    	if (nums == null || nums.length <= 1) return;
    	// if i is odd: nums[i] >= nums[i - 1]
    	// if i is even: nums[i] <= nums[i - 1]
    	for (int i = 1; i < nums.length; i++) {
    	    if (i % 2 == 0 && nums[i] > nums[i - 1]
    	        || i % 2 == 1 && nums[i] < nums[i - 1]) {
    	        swap(nums, i - 1, i);
    	    }
    	}
    }

    private void swap(int[] nums, int i, int j) {
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    }
}
