package leetcode.facebook;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 * @author qz
 *
 */
public class TargetSum {
	
	public int findTargetSumWays_dp(int[] nums, int S) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int newS = (S + sum) / 2;
        if (S > sum || newS * 2 < S + sum) return 0;
        
        int[] dp = new int[newS + 1];
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
        	for (int j = newS; j >= nums[i]; j--) {
        		dp[j] += dp[j - nums[i]];
        	}
        }
        
        return dp[newS];
    }

	int ans = 0;
    public int findTargetSumWays_naive(int[] nums, int S) {
        if (nums.length == 0) return 0;
        find(nums, 0, S);
        return ans;
    }
    
    private void find(int[] nums, int index, int S) {
        if (index == nums.length) {
            if (S == 0) ans++;
            return;
        }
        
        find(nums, index + 1, S - nums[index]);
        find(nums, index + 1, S + nums[index]);
    }
}
