package leetcode.amazon;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 * @author qz
 *
 */
public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int m = chars.length;
        if (m <= 1) return m;

        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
        	dp[i][i] = 1;
        }
        for (int l = 2; l <= m; l++) {
        	for (int i = 0; i < m - l + 1; i++) {
        		int j = i + l - 1;
        		dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        		if (chars[i] == chars[j]) {
        			dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
        		}
        	}
        }

        return dp[0][m - 1];
    }
}
