package leetcode.amazon;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 * @author qz
 *
 */
public class LongestPalindromicSubstring {

	// 常规解法
	int start = 0, end = 0, max = Integer.MIN_VALUE;
    public String longestPalindrome_n2(String s) {
        if (s == null || s.isEmpty()) return s;
        int i = 0, m = s.length();
        char[] chars = s.toCharArray();
        while (i < m) {
            update(chars, i, i);
            update(chars, i, i + 1);
            i++;
        }
        
        return s.substring(start, end + 1);
    }
    private void update(char[] chars, int left, int right) {
        int n = chars.length;
        while (left >= 0 && right < n && chars[left] == chars[right]) {
            if (max < right - left + 1) {
                start = left;
                end = right;
                max = right - left + 1;
            }
            left--;
            right++;
        }
    }
	
	// 使用 Manancher's Algorithm，可以在 O(n) 的时间内解决问题
	// 参考资料：https://www.felix021.com/blog/read.php?2040
	public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // abc => #a#b#c#
        String str = generateString(s);
        
        int[] palindrome = new int[str.length()];
        int mid = 0, longest = 1;
        palindrome[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            int len = 1; 
            if (mid + longest > i) {
                int mirrorOfI = mid - (i - mid);
                len = Math.min(palindrome[mirrorOfI], mid + longest - i);
            }
            
            while (i + len < str.length() && i - len >= 0) {
                if (str.charAt(i - len) != str.charAt(i + len)) {
                    break;
                }
                len++;
            }
            
            if (len > longest) {
                longest = len;
                mid = i;
            }
            
            palindrome[i] = len;
        }
        
        longest = longest - 1; // remove the extra #
        int start = (mid - 1) / 2 - (longest - 1) / 2;
        return s.substring(start, start + longest);
    }
    
    private String generateString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        
        return sb.toString();
    }
}
