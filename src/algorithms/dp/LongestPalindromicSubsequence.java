package algorithms.dp;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "bbbabccbbabc";
		System.out.println(findLongestPalindromicSubsequence(s));
	}

	/*
	 * Given a string s, find the longest palindromic subsequence's length in s.
	 * You may assume that the maximum length of s is 1000.
	 * 
	 * Example 1: Input: "bbbab" Output: 4 One possible longest palindromic
	 * subsequence is "bbbb".
	 * 
	 * Example 2: Input: "cbbd" Output: 2 One possible longest palindromic
	 * subsequence is "bb".
	 * 
	 */
	// f(i, j) = max { f(i + 1, j - 1) + 2 | a[i] = a[j], f(i + 1, j) + 1 | a[i] != a[j], f(i, j - 1) + 1 | a[i] != a[j] }
	private static int findLongestPalindromicSubsequence(String s) {
		if (s == null || s.length() == 0) return 0;
		
		char[] c = s.toCharArray();
		int n = c.length;
		
		int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (c[i] == c[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        
        printMatrix(f);
		
		return f[0][n - 1];
	}
	
	private static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
