package algorithms;

public class KMPAlorighms {

	public static void main(String[] args) {
		String S = "mississippi";
		String T = "issip";
		System.out.println(Knuth_Morris_Pratt(S, T));
	}

	private static int Knuth_Morris_Pratt(String S, String T) {
		char[] sc = S.toCharArray();
		char[] tc = T.toCharArray();
		int m = sc.length;
		int n = tc.length;
		int[] p = getPrefixes(T);
		int k = -1;	// number of characters matched
		for (int i = 0; i < m; i++) {	// scan the text from left to right
			while (k >= 0 && tc[k + 1] != sc[i]) {
				k = p[k];	// next character does not match
			}
			if (tc[k + 1] == sc[i]) {		// next character matches
				k = k + 1;
			}								
			if (k == n - 1)	{			// is all of P matched?
				return i - n + 1;
			}
			// k = p[k] // look for the next match
		}
		
		return -1;
	}
	
	// compute prefix function agains the pattern itself
	private static int[] getPrefixes(String P) {
		char[] c = P.toCharArray();
		int n = c.length;
		int[] pre = new int[n];
		pre[0] = -1;
		int k = -1;
		for (int i = 1; i < n; i++) {
			while (k >= 0 && c[k + 1] != c[i]) {
				k = pre[k];
			}
			if (c[k + 1] == c[i]) {
				k = k + 1;
			}
			pre[i] = k;
		}
		
		return pre;
	}
}
