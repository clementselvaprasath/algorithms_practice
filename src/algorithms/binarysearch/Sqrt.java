package algorithms.binarysearch;

/**
 * http://lintcode.com/en/problem/sqrtx/
 * @author qz
 *
 */
public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		System.out.println(mySqrt(a));
	}
	
	public static int mySqrt(int x) {
        if (x == 0) return 0;
        long start = 1, end = x, mid = 0;
        long res = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) res;
    }
	
	public static int sqrt(int x) {
		if (x == 0) return 0;
        long start = 1, end = x, mid = 0, ans = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long v = mid * mid;
            if (v == x) {
                return (int) mid;
            } else if (v > x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        
        return  (int) ans;
    }

	
	public static int sqrt_Newton(int x) {
        // write your code here
        if (x == 0) return 0;
        long v = x;
        while (v * v > x) {
        	v = (v + x / v) / 2;
        }
        
        return (int) v;
    }
}
