package leetcode.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * @author qz
 *
 */
public class WordSquare {

	public static void main(String[] args) {
		WordSquare ws = new WordSquare();
		String[] words = {"area","lead","wall","lady","ball"};
		List<List<String>> res = ws.wordSquares(words);
		for (List<String> list : res) {
			System.out.print("[");
			for (String str : list) {
				System.out.print(str + "  ");
			}
			System.out.println("]");
		}
	}

	public List<List<String>> wordSquares(String[] words) {
        TrieNode trie = new TrieNode();
        for (String str : words) {
            trie.insert(str);
        }
        List<List<String>> res = new ArrayList<>();
        addWord(trie, 0, words[0].length(), new ArrayList<String>(), res);
        return res;
    }

    private void addWord(TrieNode trie, int cur, int size, List<String> path, List<List<String>> res) {
        if (path.size() == size) {
            res.add(path);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : path) {
            sb.append(str.charAt(cur));
        }
        Set<String> candidates = trie.getPrefixWords(sb.toString());
        
        for (String str : candidates) {
            List<String> np = new ArrayList<String>(path);
            np.add(str);
            addWord(trie, cur + 1, size, np, res);
        }
    }
    class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        Set<String> prefixWords;

        public TrieNode () {
            children = new TrieNode[26];
            hasWord = false;
            prefixWords = new HashSet<>();
        }

        public void insert(String str) {
            if (str == null || str.length() == 0) return;
            char[] chars = str.toCharArray();
            TrieNode p = this;
            for (int i = 0; i < chars.length; i++) {
                p.prefixWords.add(str);
                int c = chars[i] - 'a';
                if (p.children[c] == null) {
                    p.children[c] = new TrieNode();
                }
                p = p.children[c];
            }
            p.hasWord = true;
        }

        public Set<String> getPrefixWords(String prefix) {
            if (prefix == null || prefix.length() == 0) return prefixWords;
            TrieNode p = this;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int c = chars[i] - 'a';
                if (p.children[c] != null) {
                    p = p.children[c];
                }
            }
            return p.prefixWords;
        }
    }
}
