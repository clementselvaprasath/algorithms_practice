package algorithms.windowsliding;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * @author qz
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main (String[] args) {
		String s = "tmmzuxt";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, len = 0;
        while (i <= j && j < c.length) {
            if (map.containsKey(c[j])) {
                i = Math.max(map.get(c[j]) + 1, i);
            }
            len = Math.max(len, j - i + 1);
            map.put(c[j], j);
            j++;
        }
        
        return Math.max(len, j - i);
    }
}
