package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Challenge O(n) time
 * 
 * @author qz
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		String s = "an++--viaj";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	// Map: <K, V>: <value i, the right most index of value i>
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0, j = 0;
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                j = Math.max(map.get(c[i]) + 1, j);
            }
            max = Math.max(i - j + 1, max);
            map.put(c[i], i);
        }
        
        return max;
    }
}
