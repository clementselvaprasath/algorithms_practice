package leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of string, delete one character each time.
 * If the string after deletion exists in the list, continue deleting.
 * If the string has one character left, return true. Otherwise, return false
 * 
 * example:
 * s = "abcde", list = {"acde", "ade", "ae"}, return true
 * 
 * s = "abcde", list = {"abcd", "bce", "ae"}, return false
 * 
 * @author qz
 *
 */
public class DeleteCharacters {

	public static void main(String[] args) {
		DeleteCharacters d = new DeleteCharacters();
		String s = "abcde";
		List<String> list1 = Arrays.asList("acde", "ade", "ae");
		List<String> list2 = Arrays.asList("abcd", "bce", "ae");
		
		System.out.println("Test 1: " + d.deleteCharacter(s, list1));
		System.out.println("Test 2: " + d.deleteCharacter(s, list2));
	}

	Map<String, Boolean> map = new HashMap<>();
	public boolean deleteCharacter(String s, List<String> dict) {
		if (s.length() <= 1 || s.length() == 2 && dict.contains(s)) return true;
		
		int n = s.length();
		String left = "", right = "";
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				left = s.substring(0, i);
			} else {
				left = "";
			}
			if (i < n - 1) {
				right = s.substring(i + 1);
			} else {
				right = "";
			}
			String ns = left + right;
			if (map.containsKey(ns)) return map.get(ns);
			if (dict.contains(ns)) {
				boolean res = deleteCharacter(ns, dict);
				if (res) return true;
				else {
					map.put(ns, res);
				}
			}
		}
		
		return false;
	}
}
