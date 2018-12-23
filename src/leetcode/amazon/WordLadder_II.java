package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author qz
 *
 */
public class WordLadder_II {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res = new ArrayList<>();
    	wordList.add(beginWord);
    	Set<String> set = new HashSet<>(wordList);
        if (beginWord.equals(endWord) || !set.contains(endWord)) return res;

        // build graph
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        buildGraph(endWord, beginWord, graph, dist, set);	
        buildPath(beginWord, endWord, new ArrayList<>(), graph, dist, res);

        return res;
    }

    private void buildPath(String cur, String end, List<String> path, Map<String, Set<String>> graph, Map<String, Integer> dist, List<List<String>> res) {
    	path.add(cur);
    	if (cur.equals(end)) {
    		res.add(new ArrayList<>(path));
    	} else {
    		for (String str : graph.get(cur)) {
    			if (dist.get(cur) == dist.get(str) + 1) {
    				buildPath(str, end, path, graph, dist, res);
    			}
    		}
    	}
    	path.remove(path.size() - 1);
    }

    private void buildGraph(String beginWord, String endWord, Map<String, Set<String>> graph, Map<String, Integer> dist, Set<String> dict) {
    	for (String str : dict) {
    		graph.put(str, new HashSet<>());
    	}

    	dist.put(beginWord, 0);
    	Queue<String> q = new LinkedList<>();
    	q.offer(beginWord);
    	while (!q.isEmpty()) {
    		String s = q.poll();
    		Set<String> adjs = findCandidates(s, dict);
    		graph.put(s, adjs);
    		for (String adj : adjs) {
    			if (!dist.containsKey(adj)) {
    				dist.put(adj, dist.get(s) + 1);
					q.offer(adj);
				}
    		}
    	}
    }

    private Set<String> findCandidates(String begin, Set<String> set) {
    	Set<String> candis = new HashSet<>();
    	char[] chars = begin.toCharArray();	
    	for (char c = 'a'; c <= 'z'; c++) {
    		for (int i = 0; i < begin.length(); i++) {  	
    			if (c == chars[i]) continue;
    			char old = chars[i];
    			chars[i] = c;
    			String s = new String(chars);
    			if (set.contains(s)) {
    				candis.add(s);
    			}
    			chars[i] = old;
    		}
    	}
    	return candis;
    }
}
