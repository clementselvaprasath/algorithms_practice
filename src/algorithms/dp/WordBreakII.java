package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

	public static void main(String[] args) {
		String s = "catsanddog";
		String a = "a";
		List<String> alist = Arrays.asList("a");
		List<String> list = Arrays.asList("cat", "cats", "and","sand", "dog");
		List<String> res = wordBreak(a, alist);
		for (String str : res) {
			System.out.println(str);
		}
	}

	/*
	 * Given a non-empty string s and a dictionary wordDict containing a list of
	 * non-empty words, add spaces in s to construct a sentence where each word
	 * is a valid dictionary word. You may assume the dictionary does not
	 * contain duplicate words.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given s = "catsanddog", dict = ["cat", "cats", "and",
	 * "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 */
	static Map<String, List<String>> done = new HashMap<>();
    static List<String> dict;

    public static List<String> wordBreak(String s, List<String> dict) {
    	WordBreakII.dict = dict;
        done.put("", Arrays.asList(""));

        return dfs(s);
    }

    static List<String> dfs(String s) {
        if (done.containsKey(s)) {
            return done.get(s);
        }
        List<String> ans = new ArrayList<>();

        for (int len = 1; len <= s.length(); len++) {  //将s 分割成s1 s2  其中s1长度为len
            String s1 = s.substring(0, len);
            String s2 = s.substring(len);

            if (dict.contains(s1)) {
                List<String> s2_res = dfs(s2);
                for (String item : s2_res) {
                    if (item == "") {
                        ans.add(s1);
                    } else {
                        ans.add(s1 + " " + item);
                    }
                }
            }
        }
        done.put(s, ans);
        return ans;
    }
}
