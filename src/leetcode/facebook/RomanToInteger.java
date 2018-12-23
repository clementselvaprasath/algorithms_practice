package leetcode.facebook;

import java.util.TreeMap;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * 
 * @author qz
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Symbol	I	V	X	L	C	D	M
    // Value	1	5	10	50	100	500	1,000
    static TreeMap<Integer, String> map = new TreeMap<>();
    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }
    public String intToRoman(int num) {
        if (num < 0) return "";
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        while (num != 0) {
            int v = num % 10;
            if (v == 4 || v == 9) {
                sb.append(map.higherEntry(v * carry).getValue()).append(map.get(carry));
            } else {
                for (int i = 0; i < v % 5; i++) {
                    sb.append(map.get(carry));
                }
                if (v >= 5) {
                    sb.append(map.get(5 * carry));
                }
            }
            num /= 10;
            carry *= 10;
        }
        
        return sb.reverse().toString();
    }
}
