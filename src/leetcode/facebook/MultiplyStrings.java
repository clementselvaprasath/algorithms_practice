package leetcode.facebook;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * @author qz
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public String multiply(String num1, String num2) {
		char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        int m = c1.length, n = c2.length;
        int[] prod = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = (c1[i] - '0') * (c2[j] - '0') + prod[i + j + 1];
                prod[i + j + 1] = p % 10;
                prod[i + j] += p / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : prod) {
            if (sb.length() == 0 && v == 0) continue;
            sb.append(v);
        }
        
        return sb.length() == 0? "0" : sb.toString();
    }
}
