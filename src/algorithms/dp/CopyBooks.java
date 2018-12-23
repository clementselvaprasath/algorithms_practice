package algorithms.dp;

public class CopyBooks {

	public static void main(String[] args) {
		int[] pages = new int[] { 3, 2, 4 };
		int k = 2;
		System.out.println(copyBooks(pages, k));

	}

	/*
	 * Given n books and the ith book has A[i] pages. You are given k people to
	 * copy the n books.
	 * 
	 * n books list in a row and each person can claim a continous range of the
	 * n books. For example one copier can copy the books from ith to jth
	 * continously, but he can not copy the 1st book, 2nd book and 4th book
	 * (without 3rd book).
	 * 
	 * They start copying books at the same time and they all cost 1 minute to
	 * copy 1 page of a book. What's the best strategy to assign books so that
	 * the slowest copier can finish at earliest time?
	 * 
	 * Example Given array A = [3,2,4], k = 2.
	 * 
	 * Return 5( First person spends 5 minutes to copy book 1 and book 2 and
	 * second person spends 4 minutes to copy book 3. )
	 */

	// f(i, j, k) = min{ max{ f(i, s, t), f(s + 1, j, k - t} | 1 <= t <= s - i + 1, 1 <= k - t <= j - s }
	public static int copyBooks(int[] p, int k) {
		if (p.length < 1)
			return 0;

		int n = p.length;
		if (n == 1) {
			return p[0];
		}
		
		if (k >= n) {
			return getMax(p, 0, n - 1);
		}

		if (k == 1) {
			return getSum(p, 0, n - 1);
		}
		
		int[][] f = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			f[i][1] = f[i - 1][1] + p[i - 1];
		}
		
		for (int i = 2; i <= n; i++) {
			for (int t = 2; t <= i && t <= k; t++) {
				f[i][t] = Integer.MAX_VALUE;
				for (int j = 1; j <= i; j++) {
					f[i][t] = Math.min(f[i][t], Math.max(f[j][t - 1], f[i][1] - f[j][1]));
				}
			}
		}

		return f[n][k];
	}

	private static int getMax(int[] p, int low, int high) {
		int max = Integer.MIN_VALUE;
		for (int i = low; i <= high; i++) {
			if (max < p[i])
				max = p[i];
		}

		return max;
	}

	private static int getSum(int[] p, int low, int high) {
		int sum = 0;
		for (int i = low; i <= high; i++) {
			sum += p[i];
		}

		return sum;
	}

}
