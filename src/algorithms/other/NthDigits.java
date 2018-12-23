package algorithms.other;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 * @author qz
 *
 */
public class NthDigits {
	
	public static void main (String[] args) {
		NthDigits nd = new NthDigits();
		int n = 1000000000;
		
		System.out.println(nd.findNthDigit(n));
	}
	
	public int findNthDigit(int n) {
        if (n < 10) return n;
    
        int len = 1;
        long start = 1, count = 9;
        while (n > len * count) {
        	n -= len * count;
        	len++;
        	count *= 10;
        	start *= 10;
        }

        long num = start + (n - 1) / len;
        int m = (n - 1) % len;
        for (int i = m; i < len - 1; i++) {
        	num /= 10;
        }
        return (int)num % 10;
    }
}
