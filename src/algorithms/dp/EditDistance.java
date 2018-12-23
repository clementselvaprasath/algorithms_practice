package algorithms.dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = Integer.MIN_VALUE;
		System.out.println(a);
		System.out.println((a + a) / 2);
	}

	/*
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * Insert a character 
	 * Delete a character 
	 * Replace a character
	 * 
	 * Example Given word1 = "mart" and word2 = "karma", return 3.
	 */
	
	/* 
	 * i, j: first i, j elements from s1 and s2. f(i, j): number of steps need to edit
	 * if (s1[i - 1] == s2[j - 1])
	 * f(i, j) = min {f(i - 1, j - 1), i > j? f(i - 1, j) + 1 : f(i, j - 1) + 1}
	 * 
	 * if (s1[i - 1] != s2[j - 1])
	 * f(i, j) = min {f(i - 1, j - 1) + 1, i > j? f(i - 1, j) + 1 : f(i, j - 1) + 1}
	 */
	public static int minDistance(String s1, String s2) {
		char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int m = c1.length;
        int n = c2.length;
        
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    f[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    f[i][j] = i;
                    continue;
                }
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                if (c1[i - 1] == c2[j - 1]) {
                	f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                	f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        
        return f[m][n];
	}
	
	
}
