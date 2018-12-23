package algorithms.dp;

public class BuyAndSellStocks_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * Example Given an example [2,1,2,0,1], return 2
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
        
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                res += prices[i] - prices[i-1]; 
            }
        }
        
        return res;
	}
}
