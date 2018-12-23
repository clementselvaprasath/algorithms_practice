package leetcode.google;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2. Note: You may assume the string contain only
 * lowercase letters.
 * 
 * @author qz
 *
 */
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqChar_onePass(String s) {
		if (s == null || s.length() == 0) return -1;
        char[] c = s.toCharArray();
        int n = c.length;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if (!set.contains(c[i])) {
                if (map.containsKey(c[i])) {
                    set.add(c[i]);
                    map.remove(c[i]);
                } else {
                    map.put(c[i], i);
                }
            }
        }
        Iterator<Integer> it = map.values().iterator();
        return it.hasNext()? it.next() : -1;
    }
	
	public int firstUniqChar_twoPass(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] c = s.toCharArray();
        int n = c.length;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[c[i] - 'a']++;
        }
        
        for (int i = 0; i < n; i++) {
            if (count[c[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
