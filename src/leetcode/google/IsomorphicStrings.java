package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while 
preserving the order of characters. No two characters may map to the same 
character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 * @author qz
 *
 */
public class IsomorphicStrings {

	// use character 256 map, for single pair
	public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) return true;
        int[] s_map = new int[256];
        int[] t_map = new int[256];
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (s_map[sc] != t_map[tc]) return false;
            s_map[sc] = t_map[tc] = i + 1;
        }
        
        return true;
    }
	
	// use pattern, for n pairs
	public boolean isIsomorphic_pattern(String s, String t) {
        if (s.equals(t)) return true;
        return getPattern(s).equals(getPattern(t));
    }
    
    public String getPattern(String s) {
        Map<Character, Character> map = new HashMap<>();
        char index = 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, index++);
            }
            sb.append(map.get(c));
        }
        
        return sb.toString();
    }
}
