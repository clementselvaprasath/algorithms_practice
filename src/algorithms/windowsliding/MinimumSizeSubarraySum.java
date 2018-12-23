package algorithms.windowsliding;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] n = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minimumSize(n, s));
	}
	
	public static int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0 || s == 0) return 0;
        
        int n = nums.length;
        int l = 0, r = 0, ans = 0, min = Integer.MAX_VALUE;
        for (r = 0; r < n; r++) {
            ans += nums[r];
            if (ans == s) {
                min = Math.min(min, r - l + 1);
                ans -= nums[l]; 
                l++;
            } else if (ans > s) {
                ans -= nums[l];
                l++;
            }
        }
        
        return min;
    }

}
