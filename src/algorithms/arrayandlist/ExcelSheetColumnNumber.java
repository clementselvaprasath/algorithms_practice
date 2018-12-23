package algorithms.arrayandlist;

/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 
 * @author qz
 *
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int m = 1, ans = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            ans += (c[i] - 'A' + 1) * m;
            m *= 26;
        }
        return ans;
    }
}
