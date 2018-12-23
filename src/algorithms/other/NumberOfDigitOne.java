package algorithms.other;

/**
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * Example:
 * 
 * Input: 13 Output: 6 Explanation: Digit 1 occurred in the following numbers:
 * 1, 10, 11, 12, 13.
 * 
 * @author qz
 *
 */
public class NumberOfDigitOne {

	/*
	 * The idea is to calculate occurrence of 1 on every digit. There are 3 scenarios, for example

if n = xyzdabc
and we are considering the occurrence of one on thousand, it should be:

(1) xyz * 1000                     if d == 0
(2) xyz * 1000 + abc + 1           if d == 1
(3) xyz * 1000 + 1000              if d > 1
iterate through all digits and sum them all will give the final answer
	 */
	public int countDigitOne(int n) {
        int sum = 0, m = 1, t = n;

        while (t > 0) {
        	int q = t % 10;
        	sum += t / 10 * m;
        	if (q == 1) sum += n % m + 1;
        	if (q > 1) sum += m;
        	m *= 10;
        	t /= 10;
        }
        
        return sum;
    }
}
