package algorithms.arrayandlist;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * @author qz
 *
 */
public class AddDigits {

	public int addDigits(int num) {
        if (num < 10) return num;

        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        
        return addDigits(ans);
    }
	
	// https://en.wikipedia.org/wiki/Digital_root
	public int addDigits_formula(int num) {
		return num == 0? 0 : (num % 9 == 0? 9 : num % 9);
    }
}
