package leetcode.facebook;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so
 * that T is a subsequence of W.
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there are multiple such minimum-length windows, return
 * the one with the left-most starting index.
 * 
 * Example 1: Input: S = "abcdebdde", T = "bde" Output: "bcde" Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same
 * length. "deb" is not a smaller window because the elements of T in the window
 * must occur in order. Note:
 * 
 * All the strings in the input will only contain lowercase letters. The length
 * of S will be in the range [1, 20000]. The length of T will be in the range
 * [1, 100].
 * 
 * @author qz
 *
 */
public class MinimumWindowSubsequence {

	public static void main(String[] args) {
		String s = "fgrqsqsnodwmxzkzxwqegkndaa";
		String t = "fnok";
		System.out.println(minWindow(s, t));
	}

	// dp[i][j]: starting index of i of T and j of S, where T[0:i] is a subsequence of S[0:j]
    // dp[i][j] = d[i - 1][j - 1] | T[i - 1] == S[j - 1] && d[i - 1][j - 1] > 0
    // dp[i][j] = d[i][j - 1] | T[i - 1] != S[j - 1]
    public static String minWindow(String S, String T) {
        if (S == null || S.isEmpty() || T == null || S.length() < T.length()) return "";
        if (S.contains(T)) return T;
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();

        int m = sc.length;
        int n = tc.length;

        int[][] dp = new int[2][m];
        dp[0][0] = (tc[0] == sc[0]? 0 : -1);
        for (int j = 1; j < m; j++) {
            dp[0][j] = (tc[0] == sc[j]? j : dp[0][j - 1]);
        }

        int old = 0, now = 0;
        for (int i = 1; i < n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < m; j++) {
                if (j < i) {
                    dp[now][j] = -1;
                    continue;
                }
                if (tc[i] == sc[j] && dp[old][j - 1] >= 0) {
                    dp[now][j] = dp[old][j - 1]; 
                } else {
                    dp[now][j] = dp[now][j - 1];
                }
            }
        }

        int left = 0, right = m - 1;
        for (int j = 0; j < m; j++) {
            int index = dp[now][j];
            if (index >= 0 && right - left > j - index) {
                left = index;
                right = j;
            }
        }

        return right - left == m - 1? "" : S.substring(left, right + 1);
    }
	
	// Brute force
	public static String minWindow_BruteForce(String S, String T) {
		if (S == null || T == null || S.length() < T.length()) return "";
        if (S.contains(T)) return T;
        
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        int m = sc.length;
        int n = tc.length;
        
        int idx = S.indexOf(tc[0]);
        String res = "";
        while (idx != -1) {
            int i = 0, j = 0;
            for (i = idx; i < m && j < n; i++) {
                if (sc[i] == tc[j]) j++;
            }
            if (j == n) {
                String val = S.substring(idx, i);
                if (res.length() > val.length()) {
                    res = val;
                }
            }
            idx = S.indexOf(tc[0], idx + 1);
        }
        return res;
    }
	
	// Apply LongestCommonSubsequence method, TLE
	public String minWindow_TLE(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) return "";
        if (S.contains(T)) return T;
        int k = T.length();
        int min = Integer.MAX_VALUE, left = 0, right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != T.charAt(0)) continue;
            for (int j = i + k; j <= S.length(); j++) {
                int len = longestCommonSubseq(S.substring(i, j), T);
                if (len == k && min > j - i + 1) {
                    min = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        
        if (min == Integer.MAX_VALUE) return "";
        return S.substring(left, right);
    }

    private int longestCommonSubseq(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int m = ac.length;
        int n = bc.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ac[i - 1] == bc[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}
