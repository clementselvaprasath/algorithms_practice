package algorithms.binarysearch;

/**
 * Given a positive integer num, write a function which 
 * returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 * @author qz
 *
 */
public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        
        int start = 0, end = num / 2, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            System.out.println(mid);
            if (num / mid == mid) {
                if (num % mid == 0) {
                    return true;
                } else {
                    end = mid;
                }
            } else if (num / mid > mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (start * start == num || end * end == num) {
            return true;
        } else {
            return false;
        }
    }
}
