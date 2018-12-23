package leetcode.google;

public class FactorialDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * We are given two numbers A and B such that B >= A. We need to compute the
	 * last digit of this resulting F such that F = B! / A! where 1 <= A, B <=
	 * 10^18 (A and B are very large)
	 * 
	 * Example Given A = 2, B = 4, return 2 A! = 2 and B! = 24, F = 24 / 2 = 12
	 * --> last digit = 2
	 * 
	 * Given A = 107, B = 109, return 2
	 * 
	 */
	
	public static int computeLastDigit(long A, long B) {
		long last = 1;
    	for (long i = A + 1; i <= B; i++) {
    	    if (i % 10 == 0) return 0;
    		last *= i % 10;
    	}
    	
    	return (int) last % 10;
    }
}
