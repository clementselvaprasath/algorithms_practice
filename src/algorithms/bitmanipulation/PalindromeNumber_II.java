package algorithms.bitmanipulation;

/**
 * Determines whether a binary representation of a non-negative integer n is a
 * palindrome
 * 
 * Notice 0 <= n <= 2^32 - 1 Have you met this question in a real interview?
 * Example Given n = 0, return True
 * 
 * Explanation: The binary representation of 0 is: 0 
 * 
 * Given n = 3, return True
 * 
 * Explanation: The binary representation of 3 is: 11 
 * 
 * Given n = 4, return False
 * 
 * Explanation: The binary representation of 4 is: 100 
 * 
 * Given n = 6, return False
 * 
 * Explanation: The binary representation of 6 is: 110
 * 
 * @author qz
 *
 */
public class PalindromeNumber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(int n) {
        if (n == 0) return true;
        if (n % 2 == 0) return false;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n >> 1;
        }
        char[] chars = sb.toString().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
