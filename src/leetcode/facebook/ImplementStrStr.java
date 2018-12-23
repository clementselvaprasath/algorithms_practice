package leetcode.facebook;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1
 * 
 * @author qz
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {
		String S = "azzzacde";
		String T = "acd";
		System.out.println(strStr_sunday(S, T));
	}
	
	// Sunday Algorithm
	public static int strStr_sunday(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int m = hc.length;
        int n = nc.length;
        
        int[] shift = new int[26];
        for (int i = 0; i < 26; i++) {
            shift[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            shift[nc[i] - 'a'] = n - i;
        }
        int s = 0;
        int j;
        while (s <= m - n) {
            j = 0;
            while (j < n && hc[s + j] == nc[j]) {
                j++;
            }
            if (j == n) {
                return s;
            }
            if (s + n >= m) return -1;
            s += shift[hc[s + n] - 'a'];
        }
        
        return -1;
    }

	// apply KMP
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int m = hc.length;
        int n = nc.length;
        int k = -1;
        int[] p = prefixes(needle);
        for (int i = 0; i < m; i++) {
            while (k >= 0 && nc[k + 1] != hc[i]) {
                k = p[k];
            }
            if (nc[k + 1] == hc[i]) {
                k = k + 1;
            }
            if (k == n - 1) {
                return i - n + 1;
            }
        }
        
        return -1;
    }
    
    private int[] prefixes(String t) {
        char[] c = t.toCharArray();
        int n = c.length;
        int[] p = new int[n];
        int k = -1;
        p[0] = -1;
        for (int i = 1; i < n; i++) {
            while (k >= 0 && c[k + 1] != c[i]) {
                k = p[k];
            }
            if (c[k + 1] == c[i]) {
                k = k + 1;
            }
            p[i] = k;
        }
        
        return p;
    }
}
