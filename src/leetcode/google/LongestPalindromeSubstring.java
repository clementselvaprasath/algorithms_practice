package leetcode.google;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
}
