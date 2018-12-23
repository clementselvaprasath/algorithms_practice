package leetcode.google;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author qz
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) return true;
        int n = s.length();
        char[] c = s.toLowerCase().toCharArray();
		int i = 0, j = n - 1;
		while (i < j) {
			while (i < n && !Character.isLetterOrDigit(c[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(c[j])) {
                j--;
            }
            if (i >= j) return true;
            if (c[i] != c[j]) return false;
            i++;
            j--;
		}
        return true;
	}
}
