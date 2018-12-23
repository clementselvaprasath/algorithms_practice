package algorithms.dp;

import java.util.Arrays;

public class BuyAndSellStocks_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(maxProfit(4, prices));
	}

	public static int maxProfit(int k, int[] prices) {
        if(prices.length<= 1 || k <= 0) return 0;
        int n = prices.length;
        int[][] buy = new int[n][k];
        int[][] sell = new int[n][k];
        for(int i = 0; i < n; i ++)
        {
        	for(int j = 0; j < k; j++)
        	{
        		buy[i][j] =  Integer.MIN_VALUE;
        		sell[i][j] =  Integer.MIN_VALUE;
        	}
        }
        buy[0][0] = -prices[0];
        for(int i = 0; i < n; i ++ )
        {
        	buy[i][0] = -prices[i];
        }
        for(int i = 1; i < n; i ++)
        {
        	for(int j = 0; j < k;j ++)
        	{
        		//buy[i][j] = buy[i-1][j];
        		buy[i][j] = Math.max(buy[i-1][j],(j>=1 ? sell[i-1][j-1] : 0)-prices[i]);
        		sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j]+prices[i]);
        	}
        }
        int maxProfit = 0;
        for(int j = 0; j < k; j ++)
        {
            maxProfit = Math.max(maxProfit, Math.max(sell[n-1][j], buy[n-1][j]));
        }
        return maxProfit;
    }
	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * k transactions.
	 * 
	 * Example Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
	 * 
	 * O(nk) time.
	 */
	public static int maxProfit1(int t, int[] p) {
		if (p == null || p.length == 0) return 0;

		int n = p.length;
		int k = 2 * t + 1;
        int[][] f = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j+=2) {
            	if (i > 1 && j > 1) {
            		f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] + p[i - 1] - p[i - 2]);
            	}
            }
            for (int j = 2; j <= k; j+=2) {
            	if (i > 1) {
            		f[i][j] = Math.max(f[i - 1][j] + p[i - 1] - p[i - 2], f[i - 1][j - 1]);
            	}
            }
        }
             
        int res = 0;
        for (int i = 1; i <= k; i+=2) {
            res = Math.max(res, f[n][i]);
        }
       
        return res;
	}
	
	public int maxProfit_arbitaryK(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        
        if (k >= n / 2) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
            }
            return sum;
        }
        
        
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        sell[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                sell[j] = Math.max(sell[j], buy[j] + prices[i - 1]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i - 1]);
                //f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i - 1]);
                //f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i - 1]);
            }
        }
        
        return sell[k];
    }
}
