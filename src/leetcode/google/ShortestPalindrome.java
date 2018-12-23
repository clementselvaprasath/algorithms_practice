package leetcode.google;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author qz
 *
 */
public class ShortestPalindrome {

	public static void main(String[] args) {

		String str = "abca";
		String str1 = "abba";
		String str2 = "ababca";
		System.out.println(shortestPalindrome_linear(str2));
		System.out.println(shortestPalindrome(str2));
	}

	public static String shortestPalindrome(String s) {
		if (s == null || s.length() <= 1) return s;
        
        char[] c = s.toCharArray();
        int n = c.length;
        int left = 0, right = 0;
        int i = n - 1;
        while (i >= 0) {
            right = i;
            while (left < right && c[left] == c[right]) {
                left++;
                right--;
            }
            if (left >= right) {
                right = i;
                break;
            }
            i--;
            left = 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(right + 1)).reverse().append(s);

        return sb.toString();
    }
	
	public static String shortestPalindrome_linear(String s) {
		int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {//找到第一个使他不回文的位置
           if (s.charAt(i) == s.charAt(j)) { 
               j += 1; 
           }
        }

        if (j == s.length()) {  //本身是回文
            return s; 
        }

        String suffix = s.substring(j); // 后缀不能够匹配的字符串
        String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome_linear(s.substring(0, j)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文
        String ans = prefix + mid  + suffix;

        return  ans;
	}
}
