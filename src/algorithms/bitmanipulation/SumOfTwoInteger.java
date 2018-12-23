package algorithms.bitmanipulation;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 * @author qz
 *
 */
public class SumOfTwoInteger {
	
	public int getSum(int a, int b) {
		// when carry is 0, return a
        if (b == 0) return a;
        
        int sum = a ^ b;	// get sum by XOR
        int carry = (a & b) << 1;	// get carry by first AND, then left shift by one digit
        return getSum(sum, carry);	// recursively call
    }
}
