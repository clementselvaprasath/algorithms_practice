package algorithms.bitmanipulation;

/**
 * http://www.lintcode.com/en/problem/o1-check-power-of-2/
 * @author qz
 *
 */
public class CheckPowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
