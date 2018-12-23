package leetcode.google;

public class RepeatString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Write a function, give a string A consisting of N characters and a string
	 * B consisting of M characters, returns the number of times A must be
	 * stated such that B is a substring of the repeated string. If B can never
	 * be a substring of the repeated A, then your function should return -1.
	 * 
	 * Notice Assume that 0 <= N <= 1000, 1 <= M <= 1000
	 * 
	 * Example Given A = abcd, B = cdabcdab
	 * 
	 * your function should return 3, bcause after stating string A three times
	 * we otain the string abcdabcdabcd. String B is a substring of this string.
	 */
	
	public static int repeatedString(String A, String B) {
		if (A == null || B == null || B.length() == 0) return 0;
        if (A.length() == 0) return -1;
        int a = A.length();
        int b = B.length();
        if (a >= b) {
            if (A.contains(B)) return 1;
            else if ((A + A).contains(B)) return 2;
            else return -1;
        } else {
            if (!B.contains(A)) return -1;
            int pos = B.indexOf(A);
            int left = repeatedString(A, B.substring(0, pos));
            int right = repeatedString(A, B.substring(pos + a));
            if (left == -1 || right == -1) {
                return -1;
            } else {
                return left + right + 1;
            }
        }
    }
	
	public static int repeatedString_iterate(String A, String B) {
        if (A == null || A.length() == 0) return -1;
        if (B == null || B.length() == 0) return 0;
        
        if (A.length() >= B.length()) {
            if (A.contains(B)) {
                return 1;
            } else {
                return -1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B)) {
            return count;
        }
        
        sb.append(A);
        if (sb.toString().contains(B)) {
            return count + 1;
        }
        
        return -1;
    }
}
