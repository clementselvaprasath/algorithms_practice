package leetcode.google;

/**
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * @author qz
 *
 */
public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int repeatedStringMatch(String A, String B) {
		if (A == null || B == null)
			return 0;

		String temp = A;
		int count = 1;
		while (temp.length() < B.length()) {
			count++;
			temp += A;
		}
		if (temp.contains(B)) {
			return count;
		}
		temp += A;
		if (temp.contains(B)) {
			return count + 1;
		}

		return -1;
	}
}
