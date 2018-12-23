package algorithms.dp;

/**
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such 
 * that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 * @author qz
 *
 */
public class PartitionEqualSubsetSum {

	public boolean canPartition_dp(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) return false;
        int half = sum / 2;
        
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
        	for (int j = half; j >= 1; j--) {
                if (j >= nums[i]) dp[j] |= dp[j - nums[i]];
            }
        }
        
        return dp[half];
    }
}
