package leetcode.facebook;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author qz
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = ac.length - 1, j = bc.length - 1;
        while (i >= 0 && j >= 0) {
        	int sum = (ac[i] - '0') + (bc[j] - '0') + carry;
        	sb.insert(0, sum % 2);
        	carry = sum / 2;
        	i--;
        	j--;
        }

        char[] tmp = null;
        int k = 0;
        if (i >= 0) {
        	tmp = ac;
        	k = i;
        } else if (j >= 0) {
        	tmp = bc;
        	k = j;
        }


        if (tmp != null) {
        	while (k >= 0) {
	        	int sum = (tmp[k] - '0') + carry;
	        	sb.insert(0, sum % 2);
	        	carry = sum / 2;
	        	k--;
	        }
        }
        if (carry > 0) {
        	sb.insert(0, carry);
        }

        return sb.toString();
    }
}
