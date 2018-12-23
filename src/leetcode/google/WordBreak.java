package leetcode.google;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
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
}
