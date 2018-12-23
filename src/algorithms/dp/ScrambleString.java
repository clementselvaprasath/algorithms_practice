package algorithms.dp;

public class ScrambleString {

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		String s3 = "rgeat";
		System.out.println(isScramble(s1, s2));
		System.out.println(isScramble(s1, s3));
		System.out.println(isScramble(s2, s3));
	}

	/*
	 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	 * Below is one possible representation of s1 = "great":
		    great
		   /    \
		  gr    eat
		 / \    /  \
		g   r  e   at
		           / \
		          a   t
	 * To scramble the string, we may choose any non-leaf node and swap its two children.
	 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

		    rgeat
		   /    \
		  rg    eat
		 / \    /  \
		r   g  e   at
		           / \
		          a   t
	 * We say that "rgeat" is a scrambled string of "great".
	 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

		    rgtae
		   /    \
		  rg    tae
		 / \    /  \
		r   g  ta  e
		       / \
		      t   a
	 *	We say that "rgtae" is a scrambled string of "great".
	 *	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
	 *  Challenge 
	 *  O(n3) time
	 */
	
	//f(i, j, k), i: starting index of s1; j: starting index of s2; k: length 
	//f(i, j, k) = OR { f(i, j, w) && f(i + w, j + w, k - w) } || OR { f(i, j + k - w, w) && f(i + w , j, k - w) }
	public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (c1[i] == c2[j]) {
        			f[i][j][1] = true;
        		} else {
        			f[i][j][1] = false;
        		}
        	}
        }
        
        for (int k = 2; k <= n; k++) {
        	for (int i = 0; i <= n - k; i++) {
            	for (int j = 0; j <= n - k; j++) {
            		f[i][j][k] = false;
            		for (int w = 1; w < k; w++) {
            			if (f[i][j][w] && f[i + w][j + w][k - w]) {
            				f[i][j][k] = true;
            				break;
            			}
            			if (f[i][j + k - w][w] && f[i + w][j][k - w]) {
            				f[i][j][k] = true;
            				break;
            			}
            		}
            	}
            }
		}
        
		return f[0][0][n];
    }
}

























