package leetcode.apple;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * @author qz
 *
 */
public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(1));
	}

	public static int reverseBits(int n) {
        if (n == 0) return 0;
        int count = 0, ans = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans += (1 << (31 - count));
            }
            count++;
            n = n >> 1;
        }
        System.out.println(count);
        return ans;
    }
}
