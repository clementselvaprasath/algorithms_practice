package algorithms.arrayandlist;

/**
 * http://lintcode.com/en/problem/string-to-integer-ii/
 * 
 * mplement function atoi to convert a string to an integer.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * If the correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Example "10" => 10 "-1" => -1 "123123123123123" => 2147483647 "1.0" => 1
 * 
 * @author qz
 *
 */
public class StringToIInteger_II {

	public static void main(String[] args) {
		String s = "1234567890123456789012345678901234567890";
		System.out.println(atoi(s));

	}

	/**
	 * clarify the corner cases
	 * 
	 * @param str
	 * @return
	 */
	public static int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.contains(".")) {
            str = str.substring(0, str.indexOf("."));
        }
        
        double res = 0;
        char[] c = str.toCharArray();
        int i = 0;
        if (c[0] == '-' || c[0] == '+') {
            i = 1;
        }
        
        for (; i < c.length; i++) {
            if (!Character.isDigit(c[i])) break;
            res = res * 10 + (c[i] - '0');
        }
        
        if (c[0] == '-') {
            res = -res;
        }
        
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        
        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        
        return (int) res;
    }
}
