package algorithms.dp;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Example 
	 * Given S = "rabbbit", T = "rabbit", return 3.
	 * 
	 * Challenge 
	 * Do it in O(n2) time and O(n) memory.
	 * 
	 * O(n2) memory is also acceptable if you do not know how to optimize
	 * memory.
	 * 
	 */
	
	/*
	 * i, j: first i, j elements from S and T. f(i, j): number of distinct subsequence
	 * The last element of T can be either  match the last element of S or not.
	 * if matched and chose, f(i, j) = f(i - 1, j - 1). If not chose, f(i, j) = f(i - 1, j)
	 * Total f(i, j) is f(i, j) = f(i - 1, j - 1) + f(i - 1, j)
	 * f(i, j) = 1 | j = 0
	 * f(i, j) = f(i - 1, j - 1)  + f(i - 1, j) | S[i - 1] == T[j - 1]
	 * f(i, j) = f(i - 1, j) | S[i - 1] != T[j - 1]
	 * f(i, j) = 0 | i < j
	 */
	public static int numDistinct(String S, String T) {
		int m = S.length();
        int n = T.length();
        if (m < n) return 0;
        
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                if (i < j) {
                    f[i][j] = 0;
                    continue;
                }
                // do not consider the last character
                f[i][j] = f[i - 1][j];
                if (sc[i - 1] == tc[j - 1]) {
                	// last character are the same
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        
        return f[m][n];
	}
	
	public int numDistinct_spaceOptimal(String S, String T) {
        int m = S.length();
        int n = T.length();
        if (m < n) return 0;
        
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        
        int[][] f = new int[2][n + 1];
        int old = 0, now = 0;
        for (int i = 0; i <= m; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    f[now][j] = 1;
                    continue;
                }
                if (i == 0) {
                    f[now][j] = 0;
                    continue;
                }
                f[now][j] = f[old][j];
                if (sc[i - 1] == tc[j - 1]) {
                    f[now][j] += f[old][j - 1];
                }
            }
        }
        
        return f[now][n];
    }
}
