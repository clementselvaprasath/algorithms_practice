package algorithms.dp;

public class BuyAndSellStocks_III {

	public static void main(String[] args) {
		int[] a = {2,1,4,5,2,9,7};
		System.out.println(maxProfit(a));
	}

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Example Given an example [4,4,6,1,1,4,2,5], return 6.
	 */
	
	/* five phases: { buy 0, sell 0 }, { buy 1, sell 0 }, { buy 1, sell 1 }, { buy 2, sell 1 }, { buy 2, sell 2 }
	 * 
	 * f(i, j): profit of ith day and jth phases. p[i]: prices of ith day
	 * j = 1, 3, 5: f(i, j) = max { f(i - 1, j), f(i - 1, j - 1) + p[i] - p[i-1] }
	 * j = 2, 4:	f(i, j) = max { f(i - 1, j) + p[i] - p[j], f(i - 1, j - 1) }
	 * 
	 */
	public static int maxProfit(int[] p) {
		if (p == null || p.length == 0) return 0;

		int n = p.length;
        int[][] f = new int[n+1][6];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j+=2) {
            	if (i > 1 && j > 1) {
            		f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] + p[i - 1] - p[i - 2]);
            	}
            }
            for (int j = 2; j <= 5; j+=2) {
            	if (i > 1) {
            		f[i][j] = Math.max(f[i - 1][j] + p[i - 1] - p[i - 2], f[i - 1][j - 1]);
            	}
            }
        }
             
        int res = 0;
        for (int i = 1; i <= 5; i+=2) {
            res = Math.max(res, f[n][i]);
        }
       
        return res;
	}
}
