package algorithms.dp;

public class BackPack_I {

	public static void main(String[] args) {
		int[] a = {3,4,8,5};
		int m = 10;
		System.out.println(backPack(m, a));
	}

	/*
	 * Given n items with size Ai, an integer m denotes the size of a backpack.
	 * How full you can fill this backpack?
	 * 
	 * Example If we have 4 items with size [2, 3, 5, 7], the backpack size is
	 * 11, we can select [2, 3, 5], so that the max size we can fill this
	 * backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so
	 * that we can fulfill the backpack.
	 * 
	 * You function should return the max size we can fill in the given
	 * backpack.
	 * 
	 * Challenge O(n x m) time and O(m) memory.
	 * 
	 * O(n x m) memory is also acceptable if you do not know how to optimize
	 * memory.
	 */
	// f(i, w) = f(i-1, w) || f(i-1, w - A[i-1])
	public static int backPack(int m, int[] A) {
		if (A == null || A.length == 0 || m == 0) return 0;
        
        int n = A.length;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 1; i <= m; i++) {
            f[i] = false;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                f[j] = f[j] || A[i - 1] <= j && f[j - A[i - 1]];
            }
        }
        
        for (int i = m; i>= 0; i++) {
        	if (f[i]) return i;
        }
        return 0;
    }
	
	public int backPack_mnSpace(int m, int[] A) {
        int n = A.length;
        if (n <= 0 || m < 0) return 0;
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] || j >= A[i - 1] && dp[i - 1][j - A[i - 1]];
            }
        }
        
        int max = 0;
        for (int j  = m; j >= 0; j--) {
            for (int i = n; i >= 0; i--) {
                if (dp[i][j]) {
                    max = Math.max(max, j);
                }
            }
        }
        
        return max;
    }
}
