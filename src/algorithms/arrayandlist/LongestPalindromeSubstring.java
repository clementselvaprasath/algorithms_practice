package algorithms.arrayandlist;

/**
 * http://lintcode.com/en/problem/longest-palindromic-substring/
 * 
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * Have you met this question in a real interview? Yes Example Given the string
 * = "abcdzdcab", return "cdzdc".
 * 
 * Challenge O(n2) time is acceptable. Can you do it in O(n) time.
 * 
 * @author qz
 *
 */
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring ins = new LongestPalindromeSubstring();
		String s = "abcdzdcab";
		System.out.println(ins.longestPalindrome(s));
	}

	int left = 0, right = 0, max = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        char[] sc = s.toCharArray();
        int n = sc.length;
        int p = 0;
        while (p < n - 1) {
            findRange(sc, p, p);
            findRange(sc, p, p + 1);
            p++;
        }
        
        return s.substring(left, right + 1);
    }
    
    private void findRange(char[] sc, int i, int j) {
        int n = sc.length;
        while (i >= 0 && j < n && sc[i] == sc[j]) {
            if (max < j - i + 1) {
                max = j - i + 1;
                left = i;
                right = j;
            }
            i--;
            j++;
        }
    }

    // Linear
	public String longestPalindrome_linear(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int length = s.length();
		int max = 0;
		String result = "";
		for (int i = 1; i <= 2 * length - 1; i++) {
			int count = 1;
			while (i - count >= 0 && i + count <= 2 * length && get(s, i - count) == get(s, i + count)) {
				count++;
			}
			count--; // there will be one extra count for the outbound #
			if (count > max) {
				result = s.substring((i - count) / 2, (i + count) / 2);
				max = count;
			}
		}

		return result;
	}

	private char get(String s, int i) {
		if (i % 2 == 0)
			return '#';
		else
			return s.charAt(i / 2);
	}
}
