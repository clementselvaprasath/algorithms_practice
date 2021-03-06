package leetcode.amazon;

/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000. Example 1: Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice. Example 2: Input: "aba"
 * 
 * Output: False Example 3: Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 * 
 * @author qz
 *
 */
public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) return false;
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            if ((n - i) % i == 0) {
                String p = s.substring(0, i);
                int left = i, right = left + i;
                while (right <= n) {
                    if (!p.equals(s.substring(left, right))) break;
                    left += i;
                    right += i;
                }
                
                if (right > n) return true;
            }
        }
        
       	return false;
    }
}
