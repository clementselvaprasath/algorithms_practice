package leetcode.facebook;

public class AddAndSearchWord {
	TrieNode root;
    
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(root, word);
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        String word;
        
        public TrieNode () {
            children = new TrieNode[26];
            hasWord = false;
        }
        
        public void insert(String wordStr) {
            if (wordStr == null || wordStr.isEmpty()) return;
            char[] chars = wordStr.toCharArray();
            TrieNode p = this;
            for (int i = 0; i < chars.length; i++) {
                int c = chars[i] - 'a';
                if (p.children[c] == null) {
                    p.children[c] = new TrieNode();
                }
                p = p.children[c];
            }
            p.hasWord = true;
            p.word = wordStr;
        }
        
        public boolean search(TrieNode node, String wordStr) {
            if (wordStr == null || wordStr.isEmpty()) return node.hasWord;
            char[] chars = wordStr.toCharArray();
            TrieNode p = node;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '.') {
                    for (TrieNode child : p.children) {
                        if (child != null && search(child, wordStr.substring(i + 1))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    int c = chars[i] - 'a';
                    if (p.children[c] == null) {
                        return false;
                    }
                    p = p.children[c];
                }
            }
            
            return p.hasWord;
        }
    }
}
