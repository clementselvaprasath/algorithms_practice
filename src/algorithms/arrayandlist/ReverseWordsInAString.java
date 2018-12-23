package algorithms.arrayandlist;

/**
 * http://lintcode.com/en/problem/reverse-words-in-a-string/
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Have you met this question in a real interview? Yes Clarification What
 * constitutes a word? A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces? Yes. However, your
 * reversed string should not contain leading or trailing spaces. How about
 * multiple spaces between two words? Reduce them to a single space in the
 * reversed string.
 * 
 * @author qz
 *
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "How are you?";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s.trim();
        String[] ss = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = ss.length;
        sb.append(ss[n - 1]);
        for (int i = ss.length - 2; i >= 0; i--) {
            sb.append(" ").append(ss[i]);
        }
        
        return sb.toString();
    }
}
