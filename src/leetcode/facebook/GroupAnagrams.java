package leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: All inputs will be in
 * lower-case.
 * 
 * @author qz
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String nstr = new String(ch);
            if (map.containsKey(nstr)) {
                map.get(nstr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(nstr, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}
