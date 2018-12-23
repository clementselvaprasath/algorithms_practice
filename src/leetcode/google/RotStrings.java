package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class RotStrings {
	
	public static void main(String[] args) {
		RotStrings rs = new RotStrings();
		List<String> words = Arrays.asList("abbc", "bccd", "bccd", "abbc", "effg", "abbc", "effg", "xxs", "yyt");
		String[] ss = {"abc", "am"};
		List<List<String>> res = rs.groupStrings(ss);
		
		for (List<String> list : res) {
			StringJoiner sj = new StringJoiner(", ", "[", "]");
			for (String str : list) {
				sj.add(str);
			}
			System.out.println(sj.toString());
		}
	}
	
	// find the pattern
	public List<List<String>> groupStrings(String[] ss) {
        if (ss == null || ss.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : ss) {
            String pattern = getPattern(s);
            if (map.containsKey(pattern)) {
                map.get(pattern).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(pattern, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
    
	private String getPattern(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 1; i < c.length; i++) {
            if (c[i] >= c[0]) sb.append("*").append(c[i] - c[0]);
            else sb.append("*").append(c[i] + 26 - c[0]);
        }
        
        return sb.toString();
    }
	
	// need to clarify the problem:
	// 1. what is the input and output?
	// 2. does the input have duplicates? how does it impact the output?
	// 3. what if the input is empty? any invalid strings?
	public List<List<String>> getAllROTN(List<String> words) {
		if (words == null || words.isEmpty()) return new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for (String str : words) {
			if (!map.containsKey(str)) continue;
			List<String> list = new ArrayList<>();
			list.add(str);
			map.put(str, map.get(str) - 1);
			if (map.get(str) == 0) map.remove(str);
			for (int i = 0; i < 26; i++) {
				String val = getROTK(str, i);
				if (!map.containsKey(val)) continue;
				while (map.get(val) > 0) {
					map.put(val, map.get(val) - 1);
					list.add(val);
				}
				if (map.get(val) == 0) map.remove(val);
			}
			if (list.size() > 1) res.add(list);
		}
		
		return res;
	}
	
	private String getROTK(String s, int k) {
		if (k == 0) return s;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) ('a' + ((chars[i] - 'a' + k) % 26));
		}
		
		return new String(chars);
	}
}
