package leetcode.facebook;

/**
 * Number of Longest Increasing Subsequence Given an unsorted array of integers,
 * find the number of longest increasing subsequence.
 * 
 * Example 1: Input: [1,3,5,4,7] Output: 2 Explanation: The two longest
 * increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7]. Example 2: Input:
 * [2,2,2,2,2] Output: 5 Explanation: The length of longest continuous
 * increasing subsequence is 1, and there are 5 subsequences' length is 1, so
 * output 5. Note: Length of the given array will be not exceed 2000 and the
 * answer is guaranteed to be fit in 32-bit signed int.
 * 
 * 
 * @author qz
 *
 */
public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// f[i] = max(f[i], f[j] + 1), j < i
	// if (f[i] < f[j] + 1) c[i] = c[j], if (f[i] == f[j] + 1) c[i] += c[j];
	public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] c = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            c[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    c[i] = c[j];
                    max = Math.max(max, dp[i]);
                } else if (dp[i] == dp[j] + 1) {
                    c[i] += c[j];
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) res += c[i];
        }
        
        return res;
    }
}
