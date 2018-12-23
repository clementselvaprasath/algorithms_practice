package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> lists = partition(s);
		for (List<String> list : lists) {
			for (String str : list) {
				System.out.print(str + ", ");
			}
			System.out.println();
		}
	}

	/*
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 */
	public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<List<String>>();
        char[] a = s.toCharArray();
        int n = a.length;
        
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            //odd
            int left = i, right = i;
            while (left >= 0 && right < n && a[left] == a[right]) {
                f[left][right] = true;
                left--;
                right++;
            }
            //even
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && a[left] == a[right]) {
                f[left][right] = true;
                left--;
                right++;
            }
        }
        
        Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
        List<List<String>> res = new ArrayList<List<String>>();
        res.add(new ArrayList<String>());
        map.put("", res);
        return dfs(f, s, map);
    }
    
    static List<List<String>> dfs (boolean[][] f, String s, Map<String, List<List<String>>> map) {
    	if (map.containsKey(s)) {
            return map.get(s);
        }
        int n = s.length();
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = n - 1; i >= 0; i--) {
        	if (f[i][n - 1]) {
        	    if (i == 0) {
        		    res.add(Arrays.asList(s));
        	    } else if (f[i][n - 1]) {
                    List<List<String>> r = dfs(f, s.substring(0, i), map);
                    if (!r.isEmpty()) {
                        for (List<String> list : r) {
                        	List<String> tmp = new ArrayList<String>(list);
                        	tmp.add(s.substring(i, n));
                        	res.add(tmp);
                        }
                    }
        	    }
        	}
        }
        map.put(s, res);
        return res;
    }
}
