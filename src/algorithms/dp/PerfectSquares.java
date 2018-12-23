package algorithms.dp;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a positive integer n, find the least number of perfect square
	 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * Example 
	 * Given n = 12, return 3 because 12 = 4 + 4 + 4 
	 * Given n = 13, return 2 because 13 = 4 + 9
	 */
	public static int numSquares(int n) {
		if (n < 0) return 0;
        if (n == 0) return 1;
        
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
	}
}
