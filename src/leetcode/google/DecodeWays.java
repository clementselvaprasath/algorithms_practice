package leetcode.google;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author qz
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// f[i]: num of decoding until first i elements
    // if s[i - 1] > 0, f[i] += f[i - 1]
    // if s[i - 2] * 10 + s[i - 1] >= 10 && s[i - 2] * 10 + s[i - 1] <= 26, f[i] += f[i - 2];
    // f[0] = 1; if (s[0] == 0) return 0
    public int numDecodings(String S) {
        if (S == null || S.length() == 0) return 0;
        char[] sc = S.toCharArray();
        int n = sc.length;
        if (sc[0] == '0') return 0;
        
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = sc[i - 1] - '0';
            if (a > 0) f[i] += f[i - 1];
            
            int b = (sc[i - 2] - '0') * 10 + a;
            if (b == 0) return 0;
            if (b >= 10 && b <= 26) f[i] += f[i - 2];
        }
        
        return f[n];
    }
}
