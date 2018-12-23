package leetcode.facebook;

/**
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output: True
 * Explanation: You could delete the character 'c'. Note: The string will only
 * contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * @author qz
 *
 */
public class ValidPalindrome_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        char[] c = s.toCharArray();
        int n = c.length;
        
        int i = 0, j = n - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return isPalindrome(c, i + 1, j) || isPalindrome(c, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(char[] c, int start, int end) {
        while (start < end) {
            if (c[start] != c[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
