package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a list of strings words representing an English Dictionary, find
	 * the longest word in words that can be built one character at a time by
	 * other words in words. If there is more than one possible answer, return
	 * the longest word with the smallest lexicographical order.
	 * 
	 * If there is no answer, return the empty string. 
	 * Example 1: 
	 * Input: words = ["w","wo","wor","worl", "world"] 
	 * Output: "world" 
	 * Explanation: 
	 * The word "world" can be built one character at a time by "w", "wo", "wor", and
	 * "worl". 
	 * 
	 * Example 2: 
	 * Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] 
	 * Output: "apple" 
	 * Explanation: Both "apply" and "apple" can be built from other words in the dictionary. 
	 * However, "apple" is lexicographically smaller than "apply". 
	 * 
	 * Note:
	 * All the strings in the input will only contain lowercase letters. The
	 * length of words will be in the range [1, 1000]. The length of words[i]
	 * will be in the range [1, 30].
	 * 
	 */
	public static String longestWord(String[] W) {
		if (W == null || W.length == 0) return null;
        TrieNode trieNode = new TrieNode();
        for (String str : W) {
            trieNode.insert(str);
        }

        List<String> list = new ArrayList<String>();
        dfs(trieNode, list);
        String res = null;
        for (String str : list) {
            if (res == null) {
                res = str;
            } else {
                if (res.length() < str.length() 
                    || res.length() == str.length() && res.compareTo(str) > 0) {
                    res = str;
                }
            }
        }

        return res;
	}
	private static void dfs (TrieNode root, List<String> list) {
        TrieNode[] p = root.children;
        boolean hasChildren = false;
        for (int i = 0; i < 26; i++) {
            if (p[i] != null && p[i].hasWord) {
                hasChildren = true;
                dfs(p[i], list);
            }
        }
        if (!hasChildren && root.hasWord) {
            list.add(root.word);
        }
    }
}

class TrieNode {
	TrieNode[] children;
	boolean hasWord;
	String word;

	public TrieNode () {
		children = new TrieNode[26];
		hasWord = false;
	}

	public void insert (String wordStr) {
		if (wordStr == null || wordStr.length() == 0) return;
		char[] w = wordStr.toCharArray();
		TrieNode p = this;
		for (int i = 0; i < w.length; i++) {
			int c = w[i] - 'a';
			if (p.children[c] == null) {
				p.children[c] = new TrieNode();
			}
			p = p.children[c];
		}
		p.hasWord = true;
		p.word = wordStr;
	}
}