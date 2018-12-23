package algorithms.arrayandlist;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * @author qz
 *
 */
public class BasicCalculator_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0".charAt('+'));
	}

	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        char[] c = s.toCharArray();
        int n = c.length;
        char preOp = '+';
        int total = 0, prev = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == ' ') continue;
            if (Character.isDigit(c[i])) {
                int v = c[i] - '0';
                while (i + 1 < n && Character.isDigit(c[i + 1])) {
                    v = v * 10 + (c[i + 1] - '0');
                    i++;
                }
                
                if (preOp == '+') {
                    total += prev;
                    prev = v;
                } else if (preOp == '-') {
                    total += prev;
                    prev = -v;
                } else if (preOp == '*') {
                    prev *= v;
                } else if (preOp == '/') {
                    prev /= v;
                }
            } else {
                preOp = c[i];
            }
        }
        
        return total + prev;
    }
}
