package algorithms.dp;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s = "";
		String p = ".*";
		
		System.out.println(isMatch(s, p));
	}

	/*
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: boolean isMatch(string s, string p)
	 * 
	 * Example 
	 * isMatch("aa","a") → false 
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false 
	 * isMatch("aa", "a*") → true 
	 * isMatch("aa", ".*") → true 
	 * isMatch("ab", ".*") → true 
	 * isMatch("aab", "c*a*b") → true
	 */
	
	/*
	 * i, j: first i, j elements of s, p
	 * 
	 * if p[j - 1] != '*' && s[i - 1] == p[j - 1] || p[j - 1] == '.'
	 * f(i, j) = f(i - 1, j - 1)
	 * 
	 * else if (j >= 2 && p[j - 1] == '*')
	 * case1: ignore p[j - 2] and p[j - 1] -> f(i, j) |= f(i, j - 2)
	 * case2: consider p[j - 2] and p[j - 1] -> f(i, j) |= f(i - 1, j) | sc[i - 1] == pc[j - 2] || pc[j - 2] == '.'
	 * 
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int m = sc.length;
        int n = pc.length;
        
        boolean[][] f = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j<= n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = false;
                if (pc[j - 1] != '*') {
                    if (i > 0 && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.')) f[i][j] = f[i - 1][j - 1];
                } else {
                    if (j >= 2) {
                        f[i][j] = f[i][j] || f[i][j - 2];
                    }
                    if (i >= 1 && j >= 2) {
                        f[i][j] = f[i][j] || f[i - 1][j] && (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.');
                    }
                }
            }
        }
        
        return f[m][n];
	}
}
