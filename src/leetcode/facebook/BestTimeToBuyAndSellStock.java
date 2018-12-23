package leetcode.facebook;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
