package leetcode.google;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 * 
	 * Example Given [1,2,3] which represents 123, return [1,2,4]. Given [9,9,9]
	 * which represents 999, return [1,0,0,0].
	 * 
	 * 
	 */
	public static int[] plusOne(int[] D) {
		if (D == null || D.length == 0) {
			return D;
		}

		int n = D.length;
		int add = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sum = D[i] + add;
			D[i] = sum % 10;
			add = sum / 10;
		}

		if (add == 0) {
			return D;
		}
		int length = n + 1;
		int[] res = new int[length];
		res[0] = add;
		for (int i = 1; i < length; i++) {
			res[i] = D[i - 1];
		}

		return res;
	}
}
