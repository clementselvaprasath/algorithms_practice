package algorithms.dp;

public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		System.out.println(isInterleave(s1, s2, s3));
	}

	/*
	 * @param s1: A string
	 * 
	 * @param s2: A string
	 * 
	 * @param s3: A string
	 * 
	 * @return: Determine whether s3 is formed by interleaving of s1 and s2
	 */
	/*
	 * Given three strings: s1, s2, s3, determine whether s3 is formed by the
	 * interleaving of s1 and s2.
	 * 
	 * Example For s1 = "aabcc", s2 = "dbbca"
	 * 
	 * When s3 = "aadbbcbcac", return true. 
	 * When s3 = "aadbbbaccc", return false. 
	 * 
	 * Challenge O(n2) time or better
	 */
	// i, j: first i, j elements from s1 and s2
	// f(i, j) = f(i - 1, j) && s1[i - 1] == s3[i + j - 1] || f(i, j - 1) && s2[j - 1] == s3[i + j - 1]
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null) return false;
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 + n2 != s3.length()) return false;
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] f = new boolean[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }
                f[i][j] = false;
                if (i > 0) {
                    f[i][j] = f[i][j] || f[i - 1][j] && c1[i - 1] == c3[i + j - 1];
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || f[i][j - 1] && c2[j - 1] == c3[i + j - 1];
                }
            }
        }
        
        return f[n1][n2];
	}
	
	public boolean isInterleave_SpaceOptimal(String s1, String s2, String s3) {
        if (s1 == null || s2 == null) return false;
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 + n2 != s3.length()) return false;
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[] f = new boolean[n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    f[j] = true;
                    continue;
                }
                boolean temp = f[j];
                f[j] = false;
                if (i > 0) {
                    f[j] = f[j] || temp && c1[i - 1] == c3[i + j - 1];
                }
                if (j > 0) {
                    f[j] = f[j] || f[j - 1] && c2[j - 1] == c3[i + j - 1];
                }
            }
        }
        
        return f[n2];
    }
}
