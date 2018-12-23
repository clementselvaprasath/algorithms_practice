package algorithms.dp;

public class PalindromePartitioning_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a string s, cut s into some substrings such that every substring is
	 * a palindrome.
	 * 
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * 
	 * Example Given s = "aab",
	 * 
	 * Return 1 since the palindrome partitioning ["aa", "b"] could be produced
	 * using 1 cut.
	 * 
	 */
	public static int minCut(String s) {
		if (s == null || s.length() == 1) return 0;
        char[] c = s.toCharArray();
        int n = c.length;
        
        boolean[][] p = new boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i >= j) p[i][j] = true;
        //     }
        // }
        
        // for (int l = 2; l <= n; l++) {
        //     for (int i = 0; i < n - l + 1; i ++) {
        //         int j = i + l - 1;
        //         if (c[i] == c[j] && p[i+1][j-1]) {
        //             p[i][j] = true;
        //         }
        //     }
        // }
        // generate palindrome
        int l, r;
        for (int t = 0; t < n; t++) {
            l = r = t;
            // odd
            while (l >= 0 && r < n && c[l] == c[r]) {
                p[l][r] = true;
                l--;
                r++;
            }
            // even
            l = t;
            r = t + 1;
            while (l >= 0 && r < n && c[l] == c[r]) {
                p[l][r] = true;
                l--;
                r++;
            }
        }
        
        int[] f = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (p[0][i]) {
                f[i] = 0;
                continue;
            }
            f[i] = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (p[k+1][i] && f[i] > f[k] + 1) {
                    f[i] = f[k] + 1; 
                }
            }
        }
        
        return f[n-1];
	}
}
