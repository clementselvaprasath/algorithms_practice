package algorithms.dp;

public class OnesAndZeroes {

	public static void main(String[] args) {
		String[] s = {"10","0001","111001","1","0"};
		int m = 5;
		int n = 3;
		System.out.println(findMaxForm(s, m, n));
	}

	/*
	 * In the computer world, use restricted resource you have to generate
	 * maximum benefit is what we always want to pursue.
	 * 
	 * For now, suppose you are a dominator of m 0s and n 1s respectively. On
	 * the other hand, there is an array with strings consisting of only 0s and
	 * 1s.
	 * 
	 * Now your task is to find the maximum number of strings that you can form
	 * with given m 0s and n 1s. Each 0 and 1 can be used at most once.
	 * 
	 * Note: The given numbers of 0s and 1s will both not exceed 100 The size of
	 * given string array won't exceed 600. 
	 * 
	 * Example 1: 
	 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3 
	 * Output: 4
	 * 
	 * Explanation: This are totally 4 strings can be formed by the using of 5
	 * 0s and 3 1s, which are “10,”0001”,”1”,”0” 
	 * 
	 * Example 2: 
	 * Input: Array = {"10", "0", "1"}, m = 1, n = 1 
	 * Output: 2
	 * 
	 * Explanation: You could form "10", but then you'd have nothing left.
	 * Better form "0" and "1".
	 * 
	 */
	
	/*
	 * i, j, k: the number that i 0s and j 1s can construct from k items from array s. 
	 * f(i, j, k): number of strings can be constructed from the array
	 * f(i, j, k) = max { f(i, j, k - 1), f(i - p, j - q, k - 1) + 1  | 0 <= p <= i, 0 <= q <=j }
	 */
	public static int findMaxForm(String[] s, int m, int n) {
		if (s.length == 0) return 0;
		if (m == 0 && n == 0) return 0;
		int k = s.length;
		int[][][] f = new int[m + 1][n + 1][k + 1];
		int[] cnt0 = new int[k];
		int[] cnt1 = new int[k];
		for (int i = 0; i < k; i++) {
			char[] c = s[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				if (c[j] == '0') {
					cnt0[i]++;
				}
				if (c[j] == '1') {
					cnt1[i]++;
				}
			}
		}
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= k; l++) {
					if (i == 0 && j == 0 || l == 0) {
						f[i][j][l] = 0;
						continue;
					}
					f[i][j][l] = f[i][j][l - 1];
					if (i >= cnt0[l - 1] && j >= cnt1[l - 1]) {
						f[i][j][l] = Math.max(f[i][j][l], f[i - cnt0[l -  1]][j - cnt1[l - 1]][l - 1] + 1);
					}
				}
			}
		}
		
		return f[m][n][k];
	}
	
	/*
	 * knapsack problem
	 * find the maximum items can be put into the bag which are m and n 
	 * 
	 */
	public static int findMaxForm_Knapsack(String[] strs, int m, int n) {
		int len = strs.length;
        if (len == 0) return 0;

        int[] zeros = new int[len];
        int[] ones = new int[len];
        for (int i = 0; i < len; i++) {
        	for (char c : strs[i].toCharArray()) {
        		if (c == '0') {
        			zeros[i]++;
        		} else {
        			ones[i]++;
        		}
        	}
        }

        // dp[i][j][k] = max(dp[i][j][k], dp[i][j][k - 1] + 1 if i - z[k] >= 0 && j - o[k] >= 0)
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < len; k++) {
        	for (int i = m; i >= 0; i--) {
        		for (int j = n; j >= 0; j--) {
                    if (i == 0 && j == 0) continue;
        			if (i >= zeros[k] && j >= ones[k]) {
        				dp[i][j] = Math.max(dp[i][j], dp[i - zeros[k]][j - ones[k]] + 1);
        			}
        		}
        	}
        }

        return dp[m][n];
	}
}










