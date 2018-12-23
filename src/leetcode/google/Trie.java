package leetcode.google;

public class Trie {
    Trie[] children;
    boolean hasWord;
    
    public Trie() {
        children = new Trie[26];
        hasWord = false;
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        char[] c = word.toCharArray();
        Trie p = this;
        for (int i = 0; i < c.length; i++) {
            int v = c[i] - 'a';
            if (p.children[v] == null) {
                p.children[v] = new Trie();
            }
            p = p.children[v];
        }
        p.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        char[] c = word.toCharArray();
        Trie p = this;
        for (int i = 0; i < c.length; i++) {
            int v = c[i] - 'a';
            if (p.children[v] == null) {
                return false;
            }
            p = p.children[v];
        }
        
        return p.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        char[] c = prefix.toCharArray();
        Trie p = this;
        for (int i = 0; i < c.length; i++) {
            int v = c[i] - 'a';
            if (p.children[v] == null) {
                return false;
            }
            p = p.children[v];
        }
        
        return true;
    }
}
