package leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.
f(String prefix, String suffix). It will return the word with given 
prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.

 * @author qz
 *
 */
public class PrefixAndSuffixSearch {

	class WordFilter {

		TrieNode trieNode;

	    public WordFilter(String[] words) {
	        trieNode = new TrieNode();
	        Map<String, Integer> map = new HashMap<>();
	        for (int i = 0; i < words.length; i++) {
	        	map.put(words[i], i);
	        }
	        for (String str : map.keySet()) {
	        	trieNode.insert(str, map.get(str));
	        }
	    }
	    
	    public int f(String prefix, String suffix) {
	        Set<Integer> p = trieNode.getPrefixList(prefix);
	        Set<Integer> s = trieNode.getSuffixList(suffix);
	        if (p.isEmpty() || s.isEmpty()) return -1;
	        
	        int max = -1;
	        for (Integer i : s) {
	            if (p.contains(i)) {
	                max = Math.max(max, i);
	            }
	        }
	        return max;
	    }

	    private class TrieNode {
	    	TrieNode[] prefix;
	    	TrieNode[] suffix;
	    	Set<Integer> prefixWords;
	    	Set<Integer> suffixWords;

	    	public TrieNode() {
	    		prefix = new TrieNode[26];
	    		suffix = new TrieNode[26];
	    		prefixWords = new HashSet<>();
	    		suffixWords = new HashSet<>();
	    	}

	    	public void insert(String str, int weight) {
	    		if (str.isEmpty()) return;
	    		insert_prefix(str, weight);
	    		insert_suffix(str, weight);
	    	}

	    	private void insert_prefix(String str, int weight) {
	    		TrieNode p = this;
	            p.prefixWords.add(weight);
	    		for (char c : str.toCharArray()) {
	    			int k = c - 'a';
	    			if (p.prefix[k] == null) {
	    				p.prefix[k] = new TrieNode();
	    			}
	    			p = p.prefix[k];
	                p.prefixWords.add(weight);
	    		}
	    	}
	    	private void insert_suffix(String str, int weight) {
	    		char[] chars = str.toCharArray();
	    		TrieNode p = this;
	            p.suffixWords.add(weight);
	    		for (int i = chars.length - 1; i >= 0; i--) {
	    			int k = chars[i] - 'a';
	    			if (p.suffix[k] == null) {
	    				p.suffix[k] = new TrieNode();
	    			}
	    			p = p.suffix[k];
	                p.suffixWords.add(weight);
	    		}
	    	}

	    	public Set<Integer> getPrefixList(String prefix) {
	    		if (prefix.isEmpty()) return this.prefixWords;
	    		TrieNode p = this;
	    		for (char c : prefix.toCharArray()) {
	    			int k = c - 'a';
	    			if (p.prefix[k] == null) return new HashSet<>();
	    			p = p.prefix[k];
	    		}
	            
	    		return p.prefixWords;
	    	}

	    	public Set<Integer> getSuffixList(String suffix) {
	    		if (suffix.isEmpty()) return this.suffixWords;
	    		TrieNode p = this;
	    		for (int i = suffix.length() - 1; i >= 0; i--) {
	    			int k = suffix.charAt(i) - 'a';
	    			if (p.suffix[k] == null) return new HashSet<>();
	    			p = p.suffix[k];
	    		}
	    		return p.suffixWords;
	    	}
	    }
	}

	/**
	 * Your WordFilter object will be instantiated and called as such:
	 * WordFilter obj = new WordFilter(words);
	 * int param_1 = obj.f(prefix,suffix);
	 */
}
