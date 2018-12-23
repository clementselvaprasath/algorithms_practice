package algorithms.dp;

public class BuyAndSellStocks_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * Example Given array [3,2,3,1,2], return 1.
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        
        int max = 0;
        int[] f = new int[n];
        f[0] = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < f[i-1]) {
                f[i] = prices[i];
            } else {
                f[i] = f[i-1];
            }
            max = Math.max(max, prices[i] - f[i]);
        }
        
        return max;
	}
}
