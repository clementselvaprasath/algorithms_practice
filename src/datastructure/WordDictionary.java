package datastructure;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. 
 * A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") 
 * addWord("dad") 
 * addWord("mad") 
 * search("pad") -> false
 * search("bad") -> true 
 * search(".ad") -> true 
 * search("b..") -> true 
 * 
 * Note: 
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
	WordDictionary[] children;
	boolean hasWord;

	/** Initialize your data structure here. */
    public WordDictionary() {
        children = new WordDictionary[26];
        hasWord = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        WordDictionary p = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
        	int c = w[i] - 'a';
        	if (p.children[c] == null) {
        		p.children[c] = new WordDictionary();
        	}
        	p = p.children[c];
        }
        p.hasWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(this, word.toCharArray(), 0);
    }

    private boolean find(WordDictionary p, char[] arr, int k) {
    	if (k == arr.length) return p.hasWord;
    	if (arr[k] != '.') {
    		return p.children[arr[k] - 'a'] != null && find(p.children[arr[k] - 'a'], arr, k + 1);
    	}
    	
    	for (int i = 0; i < 26; i++) {
    		if (p.children[i] != null && find(p.children[i], arr, k + 1)) {
    			return true;
    		}
    	}
    	return false;
    }
}
