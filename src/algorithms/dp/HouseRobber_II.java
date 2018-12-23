package algorithms.dp;

public class HouseRobber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * After robbing those houses on that street, the thief has found himself a
	 * new place for his thievery so that he will not get too much attention.
	 * This time, all houses at this place are arranged in a circle. That means
	 * the first house is the neighbor of the last one. Meanwhile, the security
	 * system for these houses remain the same as for those in the previous
	 * street.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 * 
	 * Notice
	 * 
	 * This is an extension of House Robber.
	 */
	public int houseRobber2(int[] nums) {
		if (nums == null || nums.length < 1) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] f1 = new int[n];  // 1 to n-1;
        int[] f2 = new int[n+1];  // 2 to n;
        
        f1[1] = nums[0];
        f2[2] = nums[1];
        for (int i = 2; i <= n; i++) {
            if (i < n) {
                f1[i] = Math.max(f1[i-1], f1[i-2] + nums[i-1]);
            }
            if (i > 2) {
                f2[i] = Math.max(f2[i-1], f2[i-2] + nums[i-1]);
            }
        }
        
        return Math.max(f1[n-1], f2[n]);
	}
}
