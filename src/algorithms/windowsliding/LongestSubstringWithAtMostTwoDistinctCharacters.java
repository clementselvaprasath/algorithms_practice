package algorithms.windowsliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s , find the length of the longest 
 * substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 * @author qz
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length(), k = 2;
        
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            while (map.size() > k) {
                int count = map.get(c[left]) - 1;
                if (count == 0) {
                    map.remove(c[left]);
                } else {
                    map.put(c[left], count);
                }
                left++;
            }
            max = Math.max(i - left + 1, max);
        }
        
        return max;
    }
}
