package algorithms.dp;

public class CoinsInALine_III {

	public static void main(String[] args) {
		int[] a = { 1, 5, 233, 7, 9, 20 };
		System.out.println(firstWillWin(a));
	}

	/*
	 * There are n coins with different value in a line. Two players take turns
	 * to take the first coin or last coin until there are no more coins left.
	 * The player who take the coins with the most value wins.
	 * 
	 * Could you please decide the first player will win or lose?
	 * 
	 * Example Given values array A = [1,5,233,7], return true.
	 * 
	 */
	
	/*
	 * s(n): total value of length n, f(n) = s(n) - s(n - 1)
	 * let m is the last amount been chosen. we have s(n) = m + s(n - 2)
	 * therefore, f(n) = s(n) - s(n - 1) = m + s(n - 2) - s(n - 1) = m - f(n - 1);
	 */
	public static boolean firstWillWin(int[] v) {
		if (v == null || v.length == 0) return true;
		int n = v.length;
		
		int[][] f = new int[n][n];
		for (int i = 0; i < n; i++) {
			f[i][i] = v[i];
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				f[i][j] = Math.max(v[i] - f[i + 1][j], v[j] - f[i][j - 1]);
			}
		}
		
		return f[0][n - 1] >= 0;
	}
}
