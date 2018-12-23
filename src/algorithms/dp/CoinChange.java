package algorithms.dp;

public class CoinChange {

	public static void main(String[] args) {
		int[] a = new int[] { 186, 419, 83, 408 };
		int[] b = { 1, 2, 5 };
		int amount = 6249;
		int amount2 = 11;

		System.out.println(coinChange(b, amount2));
	}

	/*
	 * You are given coins of different denominations and a total amount of
	 * money amount. Write a function to compute the fewest number of coins that
	 * you need to make up that amount. If that amount of money cannot be made
	 * up by any combination of the coins, return -1.
	 * 
	 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
	 * 
	 * Example 2: coins = [2], amount = 3 return -1.
	 * 
	 */
	private static int coinChange(int[] coins, int m) {
		if (coins == null || coins.length == 0) return 0;
		int n = coins.length;

		int[] f = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			f[i] = -1;
		}
		for (int i = 1; i <= m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i >= coins[j] && f[i - coins[j]] >= 0) {
					min = Math.min(min, f[i - coins[j]] + 1);
				}
			}
			if (min != Integer.MAX_VALUE) f[i] = min;
		}

		return f[m];
	}
}
