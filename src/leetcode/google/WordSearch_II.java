package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * 	[
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
 * 
 * Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * click to show hint.
 * 
 * You would need to optimize your backtracking to pass the larger test. Could
 * you stop backtracking earlier?
 * 
 * If the current candidate does not exist in all words' prefix, you could stop
 * backtracking immediately. What kind of data structure could answer such query
 * efficiently? Does a hash table work? Why or why not? How about a Trie? If you
 * would like to learn how to implement a basic trie, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 * 
 * @author qz
 *
 */
public class WordSearch_II {

	int[] idx = {-1, 0, 1, 0};
    int[] idy = {0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return new ArrayList<>();
        
        TrieNode trie = new TrieNode();
        for (String str : words) {
            trie.insert(str);
        }
        
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie, visited, res);
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int r, int c, TrieNode root, boolean[][] visited, List<String> res) {
        int k = board[r][c] - 'a';
        TrieNode p = root.children[k];
        if (p == null) return;
        if (p.hasWord) {
            res.add(p.word);
            // remove duplicates
            p.hasWord = false;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int x = r + idx[i];
            int y = c + idy[i];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) continue;
            dfs(board, x, y, p, visited, res);
        }
        visited[r][c] = false;
    }
    class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }
        
        public void insert(String wordStr) {
            if (wordStr == null || wordStr.isEmpty()) return;
            TrieNode p = this;
            char[] chars = wordStr.toCharArray();
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
    }
}
