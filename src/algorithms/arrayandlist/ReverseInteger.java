package algorithms.arrayandlist;

/**
 * http://lintcode.com/en/problem/reverse-integer/ Reverse digits of an integer.
 * Returns 0 when the reversed integer overflows (signed 32-bit integer).
 * 
 * Example Given x = 123, return 321
 * 
 * Given x = -123, return -321
 * 
 * @author qz
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverseInteger(int n) {
		long res = 0;
		while (n != 0) {
			res = res * 10 + n % 10;
			n = n / 10;
		}

		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
	}

}
