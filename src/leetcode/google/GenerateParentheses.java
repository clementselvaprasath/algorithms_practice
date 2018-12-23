package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/*
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * Example Given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 */
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        
        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(1, new HashSet<String>(Arrays.asList("()")));
    
        return new ArrayList<String>(generateParenthesis(n, map));
    }
    
    private Set<String> generateParenthesis(int n, Map<Integer, Set<String>> map) {
        if (n == 0) return map.get(n);
        if (map.containsKey(n)) return map.get(n);
        Set<String> set = generateParenthesis(n - 1, map);
        Set<String> res = new HashSet<String>();
        StringBuilder sb = null;
        for (String str : set) {
            int l = str.length();
            for (int i = 1; i <= l; i++) {
                sb = new StringBuilder();
                sb.append("(").append(str.substring(0, i)).append(")").append(str.substring(i, l));
                res.add(sb.toString());
            }
            for (int i = 1; i <= l; i++) {
                sb = new StringBuilder();
                sb.append(str.substring(0, i)).append("(").append(str.substring(i, l)).append(")");
                res.add(sb.toString());
            }
        }
        map.put(n, res);
        return res;
    }
    
    public List<String> generateParenthesis_Better(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        helpMethod(res, "", n, n);
        return res;
    }
    
    private void helpMethod(List<String> list, String str, int left, int right) {
    	if (left == 0 && right == 0) {
    		list.add(str);
    		return;
    	}
    	
    	if (left > 0) {
    		helpMethod(list, str + "(", left - 1, right);
    	}
    	
    	if (right > 0 && left < right) {
    		helpMethod(list, str + ")", left, right - 1);
    	}
    }
}
