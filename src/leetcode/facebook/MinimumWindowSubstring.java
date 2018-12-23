package leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author qz
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
        if (s != null && t != null && s.contains(t)) return t;
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tc.length; i++) {
            map.put(tc[i], map.getOrDefault(tc[i], 0) - 1);
        }
        int i = 0, j = 0, min = Integer.MAX_VALUE, l = 0, r = 0, count = map.size();
        while (j < sc.length) {
            if (map.containsKey(sc[j])) {
                map.put(sc[j], map.get(sc[j]) + 1);
                if (map.get(sc[j]) == 0 && count > 0) count--;
                while (count == 0 && (!map.containsKey(sc[i]) || map.get(sc[i]) > 0)) {
                    if (map.containsKey(sc[i])) {
                        map.put(sc[i], map.get(sc[i]) - 1);
                    }
                    i++;
                }
                if (count == 0 && min > j - i + 1) {
                    min = j - i + 1;
                    l = i;
                    r = j;
                }
            }
            j++;
        }
        
        return min == Integer.MAX_VALUE? "" : s.substring(l, r + 1);
    }
}
