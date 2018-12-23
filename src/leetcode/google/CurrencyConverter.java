package leetcode.google;

/**
 * Given a table that showing the convert rate between difference currency,
 * and init currency and target currency, find the maximum.
 * 
 * @author qz
 *
 */
public class CurrencyConverter {

	
	public static void main(String[] args) {
		
	}
	
	/*
	 * this problem needs to ask some questions:
	 * 1. how many times of conversion are allowed for each currency pair?
	 * 2. consider the loop
	 * 
	 * for simplicity, each currency pair is allowed to use once
	 */
	public double convertCurrency(double[][] rates, int init, int target) {
		if (init == target) return 1;
		
		boolean[][] used = new boolean[rates.length][rates[0].length];
		//findMaxRates(rates, used, init, target);
		return 0;
	}
}
