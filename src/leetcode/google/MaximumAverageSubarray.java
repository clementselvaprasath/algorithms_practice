package leetcode.google;

public class MaximumAverageSubarray {

	public static void main(String[] args) {
		int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648};
		int k = 2;
		System.out.println(maxAverage(nums, k));
	}

	/*
	 * Given an array with positive and negative numbers, find the maximum
	 * average subarray which length should be greater or equal to given length
	 * k.
	 * 
	 * Notice It's guaranteed that the size of the array is greater or equal to
	 * k.
	 * 
	 * Example Given nums = [1, 12, -5, -6, 50, 3], k = 3
	 * 
	 * Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
	 */
	
	/*
	 * binary search
	 * 
	 * 1. find the min and max of the array, calculate the mid.
	 * 2. apply equation:
	 * 		if (a + b + c + d) / 4 > x ==> (a - x) + (b - x) + (c - x) + (d - x) > 0;
	 * 3. find the array with the mid, if such subarray can be found, increase the start value to mid.
	 * 4. if not found, decrease the end value to mid.
	 */
	public static double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int v : nums) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        double mid = 0;
        while (max - min > 1e-9) {
            mid = (min + max) / 2;
            if (isValid(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        
        return min;
    }
    
    private static boolean isValid(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        double pre_min = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1]  - mid;
            if (i >= k) {
                if (sum[i] - pre_min > 0) {
                    return true;
                }
                pre_min = Math.min(pre_min, sum[i - k + 1]);
            }
        }
        return false;
    }
	
}
