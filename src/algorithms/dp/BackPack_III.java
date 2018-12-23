package algorithms.dp;

public class BackPack_III {

	public static void main(String[] args) {
		int[] A = { 2, 3, 5, 7};
		int[] V = { 1, 5, 2, 4};
		int m = 10;
		System.out.println(backPackIII(m, A, V));
	}

	/*
	 * Given n items with size Ai and value Vi, and a backpack with size m.
	 * What's the maximum value can you put into the backpack?
	 * 
	 * Example Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and
	 * a backpack with size 10. The maximum value is 9.
	 * 
	 * You can assume that there are infinite items.
	 * 
	 * Challenge O(n x m) memory is acceptable, can you do it in O(m) memory?
	 * 
	 */
	// f(i, w) = max{f(i - 1, w), f(i, w - A[j - 1]) + V[j - 1] | w >= A[j - 1]}
	public static int backPackIII (int m, int[] A, int[] V) {
		if (A == null || A.length == 0 || V == null || V.length == 0 
				|| A.length != V.length || m == 0) {
			return 0;
		}
        
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 1; i <= m; i++) {
        	f[i] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i >= A[j]) {
        			f[i] = Math.max(f[i], f[i - A[j]] + V[j]);
        		}
        	}
        }
        
        int max = 0;
        for (int i = 0; i <= m; i++) {
        	max = Math.max(max, f[i]);
        }
        
        return max;
	}
	
	public static int backPackIII_mnSpace(int m, int[] A, int[] V) {
		if (A == null || A.length == 0 || V == null || V.length == 0 
				|| A.length != V.length || m == 0) {
			return 0;
		}
        
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j <= m; j++) {
        		if (j >= A[i - 1]) {
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
        		}
        	}
        }
        
        int max = 0;
        for (int i = 0; i <= m; i++) {
        	for (int j = 0; j <= n; j++) {
        		max = Math.max(max, dp[i][j]);
        	}
        }
        
        return max;
	}
}
