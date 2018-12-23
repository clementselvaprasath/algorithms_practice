package algorithms.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/longest-common-prefix/
 * 
 * Given k strings, find the longest common prefix (LCP).
 * 
 * Have you met this question in a real interview? Yes Example For strings
 * "ABCD", "ABEF" and "ACEF", the LCP is "A"
 * 
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 * 
 * @author qz
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
				j++;
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

	// using trie tree
	public String longestCommonPrefix_withTrie(String[] strs) {
		// write your code here
		if (strs == null || strs.length == 0)
			return "";

		TrieNode trie = new TrieNode();
		for (String str : strs) {
			if ("".equals(str))
				return "";
			trie.insert(trie, str);
		}

		return trie.findCommonPrefix(trie);
	}

	class TrieNode {
		Map<Character, TrieNode> child;
		boolean hasWord;
		String word;
		String currentWord;

		public TrieNode() {
			child = new HashMap<>();
			hasWord = false;
			currentWord = "";
		}

		public void insert(TrieNode root, String str) {
			if (str == null || str.length() == 0)
				return;
			char[] c = str.toCharArray();
			TrieNode p = root;
			for (int i = 0; i < c.length; i++) {
				String current = p.currentWord;
				if (!p.child.containsKey(c[i])) {
					p.child.put(c[i], new TrieNode());
				}
				p = p.child.get(c[i]);
				p.currentWord = current + c[i];
			}
			p.hasWord = true;
			p.word = str;
		}

		public String findCommonPrefix(TrieNode root) {
			String res = "";
			TrieNode p = root;
			while (p.child.size() == 1) {
				for (Map.Entry<Character, TrieNode> entry : p.child.entrySet()) {
					p = entry.getValue();
					res = p.currentWord;
				}
			}

			return res;
		}
	}
}
