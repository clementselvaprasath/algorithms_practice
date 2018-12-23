package algorithms;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int n = nums.length;
		int t = 0;
		for (int i = 0; i < n; i++) {
			t ^= nums[i]; 
		}
		
		return t;
	}
}
