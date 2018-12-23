package datastructure;

public class Trie {
	public TrieNode root;
	
	public Trie () {
		root = new TrieNode();
	}
	
	public class TrieNode {
		public TrieNode[] children;
		public boolean hasWord;
		public String word;
		
		public TrieNode () {
			children = new TrieNode[26];
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
			hasWord = false;
		}
	}
	
	// insert a word
	public void insert (String str) {
		char[] word = str.toCharArray();
		TrieNode p = root;
		for (int i = 0; i < word.length; i++) {
			int c = word[i] - 'a';
			if (p.children[c] == null) {
				p.children[c] = new TrieNode();
			}
			p = p.children[c];
		}
		p.hasWord = true;
		p.word = str;
	}
	
	public boolean search (String word) {
		char[] wc = word.toCharArray();
		TrieNode p = root;
		for (int i = 0; i < wc.length; i++) {
			int c = wc[i] - 'a';
			if (p.children[c] == null) {
				return false;
			}
			p = p.children[c];
		}
		
		return p.hasWord;
	}
	
	public boolean startWith (String prefix) {
		char[] s = prefix.toCharArray();
		TrieNode p = root;
		for (int i = 0; i < s.length; i++) {
			int c = s[i] - 'a';
			if (p.children[c] == null) {
				return false;
			}
			p = p.children[c];
		}
		
		return true;
	}
}
