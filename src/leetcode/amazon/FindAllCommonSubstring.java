package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all common longest substring
 * 
 * @author qz
 *
 */
public class FindAllCommonSubstring {

	public static void main(String[] args) {
		FindAllCommonSubstring sol = new FindAllCommonSubstring();
		String s = "ABCBCBA";
		String t = "BCBBCACBC";
		List<String> res = sol.commonSubstring(s, t);
		
		for (String str : res) {
			System.out.print(str + "\t");
		}
	}

	public List<String> commonSubstring(String S, String T) {
		Set<String> res = new HashSet<>();
		char[] cs = S.toCharArray();
		char[] ct = T.toCharArray();
		
		int m = cs.length, n = ct.length;
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cs[i - 1] == ct[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] > 1) {
					res.add(S.substring(i - dp[i][j], i));
				}
			}
		}
		
		return new ArrayList<>(res);
	}
}
