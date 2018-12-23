package datastructure;

import java.util.ArrayList;
import java.util.List;

public class WordSearch_II {

	static int m = 0, n = 0;
	public static void main(String[] args) {
		char[][] c = {{'a'}};
		char[][] c2 = {{'o','a','o','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] s = {"a"};
		String[] s2 = {"oath","pea","eat","rain","oaaath"};
		printList(findWords(c2, s2));
	}

	/*
	 * Given a 2D board and a list of words from the dictionary, find all words
	 * in the board.
	 * 
	 * Each word must be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once in a word.
	 * 
	 * For example, Given words = ["oath","pea","eat","rain"] and board =
	 * 
	 * [ 
	 * 	['o','a','a','n'], `
	 * 	['e','t','a','e'], 
	 * 	['i','h','k','r'],
	 * 	['i','f','l','v'] 
	 * ]
	 * 
	 * Return ["eat","oath"]. Note: You may assume that all inputs are consist
	 * of lowercase letters a-z.
	 */
	public static List<String> findWords(char[][] board, String[] words) {
		if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<String>();
        }

        TrieNode trie = new TrieNode();
        for (String str : words) {
        	trie.insert(str);
        }

        List<String> res = new ArrayList<String>();
        m = board.length;
        n = board[0].length;

        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		dfs(board, i, j, trie, res, v);
        	}
        }

        return res;
	}
	
	private static void dfs(char[][] board, int i, int j, TrieNode root, List<String> list, boolean[][] v) {
		if (i < 0 || i >= m || j < 0 || j >= n || v[i][j]) {
            return;
        }
        int c = board[i][j] - 'a';
        TrieNode p = root.children[c];
        if (p == null) return;
        if (p.hasWord) {
        	list.add(p.word);
        	p.hasWord = false;
        }
        
        v[i][j] = true;
        dfs(board, i, j + 1, p, list, v);
        dfs(board, i, j - 1, p, list, v);
        dfs(board, i + 1, j, p, list, v);
        dfs(board, i - 1, j, p, list, v);
        v[i][j] = false;
    }
	
	private static void printList(List<String> list) {
		System.out.print("{ ");
		for (String str : list) {
			System.out.print(str + ", ");
		}
		System.out.print("\b");
		System.out.println(" }");
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
    
    public void insert(String wordStr) {
        char[] c = wordStr.toCharArray();
        TrieNode p = this;
        for (int i = 0; i < c.length; i++) {
            int v = c[i] - 'a';
            if (p.children[v] == null) {
                p.children[v] = new TrieNode();
            }
            p = p.children[v];
        }
        p.hasWord = true;
        p.word = wordStr;
    }
}