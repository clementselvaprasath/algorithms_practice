package leetcode.google;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author qz
 *
 */
public class LongestKDistString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int i = 0;
        for (int j = 0; j < c.length; j++) {
            map.put(c[j], map.getOrDefault(c[j], 0) + 1);
            if (map.size() <= k) {
                res = Math.max(res, j - i + 1);
            }
            while (map.size() > k && i < j) {
                char v = c[i];
                if (map.get(v) == 1) {
                    map.remove(v);
                } else {
                    map.put(v, map.get(v) - 1);
                }
                i++;
            }
        }

        return res;
    }
	
	// following: what if the string s was sent as a data stream? 
	public int lengthOfLongestSubstringKDistinct_datastreaming(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) return 0;

        int res = 0;
        Map<Character, Integer> exist = new HashMap<>();
        TreeMap<Integer, Character> lastOccur = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (exist.size() >= k && !exist.containsKey(c)) {
                int first = lastOccur.firstKey();
                char first_c = lastOccur.get(first);
                lastOccur.remove(first);
                exist.remove(first_c);
                j = first + 1;
            }
            if (exist.containsKey(c)) {
                lastOccur.remove(exist.get(c));
            }
            exist.put(c, i);
            lastOccur.put(i, c);
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
}
