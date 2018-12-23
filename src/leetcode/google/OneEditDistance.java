package leetcode.google;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 * 
 * @author qz
 *
 */
public class OneEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).equals(t.substring(j)) 
                    || s.substring(i).equals(t.substring(j + 1))
                    || s.substring(i + 1).equals(t.substring(j + 1));
            }
            i++;
            j++;
        }
        
        return Math.abs(t.length() - s.length()) == 1;
    }
}
