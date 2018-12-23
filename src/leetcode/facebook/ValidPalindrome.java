package leetcode.facebook;

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
		ValidPalindrome vp = new ValidPalindrome();
		
		System.out.println(vp.isPalindrome("abc"));
	}

	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] c = s.toLowerCase().toCharArray();
        int n = c.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !Character.isLetterOrDigit(c[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(c[j])) {
                j--;
            }
            if (i >= n || j < 0) return true;
            if (c[i] != c[j]) return false;
            i++;
            j--;
        }

        return true;
    }
}
