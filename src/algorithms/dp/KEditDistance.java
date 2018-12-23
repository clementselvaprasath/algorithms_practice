package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

import datastructure.Trie;
import datastructure.Trie.TrieNode;

public class KEditDistance {

	public static int n = 0;
	public static List<String> list = null;
	public static int K = 0;
	public static char[] T = null;
	
	public static void main(String[] args) {
		String[] A = {"abc", "abd", "abcd", "adc"};
		String target = "ac";
		int k = 1;
		List<String> list = findKDistString_Optimal(A, target, k);
		for(String s : list) {
			System.out.print(s + "\t");
		}
	}

	/*
	 * Given an array of string S, and a target string T,
	 * find out all strings that edit to T require steps less than
	 * k.
	 * 
	 * Example: 
	 * Input: A = {"abc", "abd", "abcd", "adc"}, Target = "ac", K = 1
	 * Output: {"abc", "adc"}
	 *
	 */
	/*
	 * apply trie
	 * sp: string ending at node p, sq: parent of sp
	 * f(sp, j) = min { f(sp, j - 1) + 1, f(sq, j) + 1, f(sq, j - 1) + 1, f(sq, j - 1) | sp[last] = target[j - 1] }
	 * 
	 */
	public static List<String> findKDistString(String[] A, String target, int kk) {
		if (A == null || A.length == 0) return null;
		List<String> list = new ArrayList<>();
		
		char[] t = target.toCharArray();
		char[] s = null;
		int m = 0, n = t.length;
		for (String ss : A) {
			s = ss.toCharArray();
			m = s.length;
			boolean[][][] f = new boolean[m + 1][n + 1][kk + 1];
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					for (int k = 0; k <= kk; k++) {
						if (i == 0) {
							f[i][j][k] = (j <= k);
							continue;
						}
						if (j == 0) {
							f[i][j][k] = (i <= k);
							continue;
						}
						if (k == 0) {
							f[i][j][k] = f[i - 1][j - 1][k] && (s[i - 1] == t[j - 1]);
							continue;
						}
						if (s[i - 1] == t[j - 1]) {
							f[i][j][k] = f[i - 1][j - 1][k];
						} else {
							f[i][j][k] = f[i - 1][j - 1][k - 1] || f[i][j - 1][k - 1] || f[i - 1][j][k - 1];
						}
					}
				}
			}
			if (f[m][n][kk]) {
				list.add(ss);
			}
		}
		
		return list;
	}
	
	/*
	 * Optimal algorithm with trie
	 * 
	 */
	public static List<String> findKDistString_Optimal(String[] A, String target, int k) {
		if (A == null || A.length == 0) return new ArrayList<>();
		
		list = new ArrayList<>();
		K = k;
		T = target.toCharArray();
		// init Trie
		Trie trie = new Trie();
		for (String s : A) {
			trie.insert(s);
		}
		
		// init search array
		n = T.length;
		int[] f = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			f[i] = i;
		}
		
		// search trie
		searchTrie(trie.root, f);
		
		return list;
	}

	// p: current node
	// f: means f(sp, n)
	// todo: find out the distance from f(sp, 0) to f(sp, n)
	private static void searchTrie(TrieNode p, int[] f) {
		int[] nf = new int[n + 1];
		// check if p has word
		if (p.hasWord) {
			if (f[f.length - 1] <= K) {
				list.add(p.word);
			}
		}
		
		// check p's children
		for (int i = 0; i < 26; i++) {
			if (p.children[i] == null) {
				continue;
			}
			
			// init nf
			// nf[j]: f[i][j]
			// f[j]: f[i - 1][j]
			nf[0] = f[0] + 1;
			for (int j = 1; j <= n; j++) {
				// f[i][j] = min (f[i-1][j-1] + 1, f[i-1][j] + 1, f[i][j - 1] + 1
				nf[j] = Math.min(Math.min(f[j - 1] + 1, f[j] + 1), nf[j - 1]);
				int c = T[j - 1] - 'a';
				if (i == c) {
					nf[j] = Math.min(nf[j], f[j - 1]);
				}
			}
			searchTrie(p.children[i], nf);
		}
	}
}
















