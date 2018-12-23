package algorithms.dp;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence). The matching should cover the entire
	 * input string (not partial).
	 * 
	 * Example isMatch("aa","a") → false 
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false 
	 * isMatch("aa", "*") → true 
	 * isMatch("aa", "a*") → true 
	 * isMatch("ab", "?*") → true 
	 * isMatch("aab", "c*a*b") → false
	 * 
	 */
	/*
	 * i, j are the first i, j elements of s, p
	 * for f(i, j)
	 * if s[i - 1] == p[j - 1] || p[j - 1] == '?'
	 * f(i, j) = f(i - 1, j - 1)
	 * 
	 * if p[j - 1] == '*', the '*' can be either used or dismissed
	 * case1: '*' was ignored. f(i, j) = f(i - 1, j - 1)
	 * case2: '*' was leveraged. f(i, j) = f(i - 1, j)
	 * 
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		char[] a = s.toCharArray();
		char[] b = p.toCharArray();
		
		int m = a.length;
		int n = b.length;
		
		boolean[][] f = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = false;
                if (b[j - 1] != '*') { 
	                if (i > 0 && (a[i - 1] == b[j - 1] || b[j - 1] == '?')) {
	                    f[i][j] = f[i][j] || f[i - 1][j - 1];
	                }
                } else {
                	// ignore '*'
                	f[i][j] = f[i][j - 1];
                    if (i > 0) {
                    	// consider '*'
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
            }
        }
		
		return f[m][n];
	}
}
