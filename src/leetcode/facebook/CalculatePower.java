package leetcode.facebook;

/**
 * Implement pow(x, n).
 * 
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000 
 * 
 * Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100
 * 
 * @author qz
 *
 */
public class CalculatePower {

	public static void main(String[] args) {
		int n = Integer.MIN_VALUE + 1;
		System.out.println(-n);

	}

	public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (x == -1) {
            if (n % 2 == 1) return x;
            else return -x;
        }
        int p = n;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                p = 0 - (n + 1);
            } else {
                p = -n;
            }
        }
        return n >= 0? pow(x, p) : 1 / pow(x, p);
    }
    
    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == Integer.MAX_VALUE) {
            if (x > 1) {
                return Double.MAX_VALUE;
            } else if (x > -1 && x < 1) {
                return 0;
            } else {
                return Double.MIN_VALUE;
            }
        }
        return myPow (x, n / 2) * myPow(x, n - n / 2);
    }
}
