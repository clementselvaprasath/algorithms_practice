package leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * 
 * @author qz
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String ns = new String(chars);
        	if (map.containsKey(ns)) {
        		map.get(ns).add(str);
        	} else {
        		List<String> list = new ArrayList<>();
        		list.add(str);
        		map.put(ns, list);
        	}
        } 

        for (List<String> list : map.values()) {
        	res.add(list);
        }

        return res;
    }
}
