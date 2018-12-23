package leetcode.google;

/**
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside 
the square brackets is being repeated exactly k times. Note that k is 
guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white 
spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any 
digits and that digits are only for those repeat numbers, k. For example, 
there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * @author qz
 *
 */
public class DecodeString {

	public String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
        	char c = s.charAt(i);
        	if (Character.isLetter(c)) {
        		sb.append(c);
        		i++;
        	} else if (Character.isDigit(c)) {
        		int left = s.indexOf("[", i);
        		int right = left + 1;
        		for (int l = 1; right < n; right++) {
        			if (s.charAt(right) == '[') {
        				l++;
        			}
        			if (s.charAt(right) == ']') {
        				l--;
        			}
        			if (l == 0) break;
        		}
        		int repeat = Integer.parseInt(s.substring(i, left));
        		String rs = decodeString(s.substring(left + 1, right));
        		for (int j = 0; j < repeat; j++) {
        			sb.append(rs);
        		}
        		i = right + 1;
        	} else {
        		i = s.indexOf("]", i) + 1;
        	}
        }

        return sb.toString();
    }
}
