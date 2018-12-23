package leetcode.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author qz
 *
 */
public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || wordList.size() == 0) return 0;

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int len = 0;
        while (!q.isEmpty()) {
        	int size = q.size();
        	len++;
        	for (int i = 0; i < size; i++) {
        		String w = q.poll();
        		if (w.equals(endWord)) {
    				return len;
    			}
        		Set<String> candidates = getCandidates(w, set);
        		for (String str : candidates) {
        			q.offer(str);
        		}
        	}
        }

        return 0;
    }

    private Set<String> getCandidates(String word, Set<String> set) {
    	Set<String> res = new HashSet<>();
    	
    	for (int i = 0; i < word.length(); i++) {
    		char[] cs = word.toCharArray();
    		for (char c = 'a'; c <= 'z'; c++) {
    			if (c == cs[i]) continue;
    			cs[i] = c;
    			String s = new String(cs);
    			if (set.contains(s)) {
    				set.remove(s);
    				res.add(s);
    			}
    		}
    	}

    	return res;
    }
}
