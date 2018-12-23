package algorithms.bitmanipulation;

/**
 * http://www.lintcode.com/en/problem/update-bits/
 * @author qz
 *
 */
public class UpdateBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int updateBits(int n, int m, int i, int j) {
        return ((~((((-1) << (31 - j)) >>> (31 - j + i)) << i)) & n) | (m << i);
    }
}
