package leetcode.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * @author qz
 *
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        if (s.length() <= 1) return wordDict.contains(s);
        if (wordDict.contains(s)) return true;
        
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        int min = getMinLength(wordDict);

        for (int j = min; j <= m; j++) {
        	for (int i = 0; i <= j - min; i++) {
        		if (dp[i] && wordDict.contains(s.substring(i, j))) {
        			dp[j] = true;
        			break;
        		}
        	}
        }

        return dp[m];
    }

    private int getMinLength(List<String> wordDict) {
    	int len = Integer.MAX_VALUE;
    	for (String str : wordDict) {
    		len = Math.min(len, str.length());
    	}

    	return len;
    }
	
	public boolean wordBreak_dp2(String s, List<String> wordDict) {
		if (s == null || s.isEmpty())
			return true;

		int m = s.length();
		boolean[][] dp = new boolean[m][m];

		for (int l = 1; l <= m; l++) {
			for (int i = 0; i < m - l + 1; i++) {
				int j = i + l - 1;
				if (wordDict.contains(s.substring(i, j + 1))) {
					dp[i][j] = true;
					continue;
				}
				for (int k = i; k < j; k++) {
					dp[i][j] = dp[i][j] || dp[i][k] && dp[k + 1][j];
				}
			}
		}

		return dp[0][m - 1];
	}
	
	Map<String, Boolean> cache = new HashMap<String, Boolean>();
    public boolean wordBreak_dp3(String s, List<String> wordDict) {
        if (s == null) return false;
        if (s.length() <= 1) return wordDict.contains(s);
        if (wordDict.contains(s)) return true;
        
        if (cache.containsKey(s)) return cache.get(s);

        for (int i = 1; i <= s.length(); i++) {
        	String left = s.substring(0, i);
        	String right = s.substring(i);
        	
        	if (wordDict.contains(left) || cache.containsKey(left) && cache.get(left)) {
        		if (wordBreak_dp3(right, wordDict)) {
        			cache.put(s, true);
        			return true;
        		}
        	}
        }

        cache.put(s, false);
        return false;
    }
}
