package algorithms.dp;

public class KSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given n distinct positive integers, integer k (k <= n) and a number
	 * target.
	 * 
	 * Find k numbers where sum is target. Calculate how many solutions there
	 * are?
	 * 
	 * Example Given [1,2,3,4], k = 2, target = 5.
	 * 
	 * There are 2 solutions: [1,4] and [2,3].
	 * 
	 * Return 2.
	 * 
	 */
	/**
	 * i: first i items, j: k numbers, k: target value
	 * f[i][j][k] = f[i-1][j][k] + f[i-1][j-1][k-A[i-1]]
	 */
	public int kSum(int[] A, int k, int t) {
		if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][t + 1];
        f[0][0][0] = 1; 
        //i: first i items, j: k items, s: target value
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int s = 0; s <= t; s++) {
                    f[i][j][s] = f[i - 1][j][s];
                    if (s >= A[i - 1] && j > 0) {
                        f[i][j][s] += f[i - 1][j - 1][s - A[i - 1]];
                    }
                }
            }
        }
        
        return f[n][k][t];
	}
}
