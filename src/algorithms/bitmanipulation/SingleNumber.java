package algorithms.bitmanipulation;

/**
 * http://lintcode.com/en/problem/single-number/
 * 
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it. xample
 * Given [1,2,2,1,3,4,3], return 4
 * 
 * Challenge One-pass, constant extra space.
 * 
 * 
 * @author qz
 *
 */
public class SingleNumber {

	public int singleNumber(int[] A) {
        int res = 0;
        for (int a : A) {
            res ^= a;
        }
        
        return res;
    }
}
