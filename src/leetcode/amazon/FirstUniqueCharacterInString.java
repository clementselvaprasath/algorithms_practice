package leetcode.amazon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * @author qz
 *
 */
public class FirstUniqueCharacterInString {

	public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> res = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
        	if (set.contains(chars[i])) {
        		res.remove(chars[i]);
        	} else {
        		res.put(chars[i], i);
        		set.add(chars[i]);
        	}
        }
        Iterator<Integer> it = res.values().iterator();
        return it.hasNext()? it.next() : -1;
    }
	
	public int firstUniqChar_2(String s) {
        int resIndex = s.length();
        
        if(resIndex == 1)
            return 0;
        
        for(char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c))
                resIndex = Math.min(resIndex, index);
        }
        
        return resIndex == s.length() ? -1 : resIndex;
    }
}
