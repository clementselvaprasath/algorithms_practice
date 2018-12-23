package algorithms.dp;

/**
 * Given a string of numbers, write a function to find the maximum value from
 * the string, you can add a + or * sign between any two numbers，It's different
 * with Calculate Maximum Value, You can insert parentheses anywhere.
 * 
 * Have you met this question in a real interview? Example Given str = 01231,
 * return 12 (0 + 1 + 2) * (3 + 1) = 12 we get the maximum value 12
 * 
 * Given str = 891, return 80 As 8 * (9 + 1) = 80, so 80 is maximum.
 * 
 * @author qz
 *
 */
public class CalculateMaxValue_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxValue(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = chars[i] - '0';
        }
        
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                int v = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    v = Math.max(v, Math.max(dp[i][k] + dp[k + 1][j], dp[i][k] * dp[k + 1][j]));
                }
                dp[i][j] = v;
            }
        }
        
        return dp[0][n - 1];
    }
}
