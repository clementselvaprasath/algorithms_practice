package algorithms.bitmanipulation;

/**
 * http://lintcode.com/en/problem/digit-counts/
 * 
 * @author qz
 *
 */
public class DigitCounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Count the number of k's between 0 and n. k can be 0 - 9. 
	 * 
	 * Example if n = 12, k = 1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 
	 * we have FIVE 1's (1, 10, 11, 12)
	 * 
	 */
	/*
     *  f[i] = f[i / 10] + f[i % 10];
     */
    // edge case::
    // when n < 10, k == n? 1 : 0
	public int digitCounts(int k, int n) {
        if (k < 0) return 0;
        
        int[] f = new int[n + 1];
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                f[i] = (i == k? 1 : 0);
            } else {
                f[i] = f[i / 10] + f[i % 10];
            }
            sum += f[i];
        }
        
        return sum;
    }
}
