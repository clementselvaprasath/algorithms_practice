package algorithms.bitmanipulation;

/**
 * http://www.lintcode.com/en/problem/a-b-problem/
 * @author qz
 *
 */
public class APlusBProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int aplusb(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }
}
