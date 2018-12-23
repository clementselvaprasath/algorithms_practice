package algorithms.dp;

/**
 * We have two special characters. The first character can be represented by one
 * bit 0. The second character can be represented by two bits (10 or 11).
 * 
 * Now given a string represented by several bits. Return whether the last
 * character must be a one-bit character or not. The given string will always
 * end with a zero.
 * 
 * Example 1: Input: bits = [1, 0, 0] Output: True Explanation: The only way to
 * decode it is two-bit character and one-bit character. So the last character
 * is one-bit character. Example 2: Input: bits = [1, 1, 1, 0] Output: False
 * Explanation: The only way to decode it is two-bit character and two-bit
 * character. So the last character is NOT one-bit character. Note:
 * 
 * 1 <= len(bits) <= 1000. bits[i] is always 0 or 1.
 * 
 * @author qz
 *
 */
public class OneBitAndTwoBitsDecode {
	public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0) return false;

        int m = bits.length;
        boolean[] dp = new boolean[m];
        for (int i = 0; i < m; i++) {
        	if (i == 0) {
        		dp[i] = true;
        		continue;
        	}
        	if (i == 1) {
        		 if (bits[i - 1] == 0) {
        		 	dp[i] = true;
        		 }
        		 continue;
        	}
        	dp[i] = dp[i - 1] && bits[i - 1] == 0 || dp[i - 2] && bits[i - 2] == 1;
        }

        return dp[m - 1];
    }
}
