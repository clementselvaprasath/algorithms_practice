package algorithms.bitmanipulation;

/**
 * http://www.lintcode.com/en/problem/flip-bits/
 * @author qz
 *
 */
public class FlipBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int count = 0;
        while (c != 0) {
            c &= c - 1;
            count++;
        }
        return count;
    }
}
