package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

 * @author qz
 *
 */
public class IntegerToEnglishWords {
	static Map<Integer, String> textMap = new HashMap<>();
	static Map<Integer, String> digitsMap = new HashMap<>();
	static {
		textMap.put(1, "One");
		textMap.put(2, "Two");
		textMap.put(3, "Three");
		textMap.put(4, "Four");
		textMap.put(5, "Five");
		textMap.put(6, "Six");
		textMap.put(7, "Seven");
		textMap.put(8, "Eight");
		textMap.put(9, "Nine");
        textMap.put(10, "Ten");
		textMap.put(11, "Eleven");
		textMap.put(12, "Twelve");
		textMap.put(13, "Thirteen");
		textMap.put(14, "Fourteen");
		textMap.put(15, "Fifteen");
		textMap.put(16, "Sixteen");
		textMap.put(17, "Seventeen");
		textMap.put(18, "Eighteen");
		textMap.put(19, "Nineteen");
		textMap.put(20, "Twenty");
		textMap.put(30, "Thirty");
		textMap.put(40, "Forty");
		textMap.put(50, "Fifty");
		textMap.put(60, "Sixty");
		textMap.put(70, "Seventy");
		textMap.put(80, "Eighty");
		textMap.put(90, "Ninety");
		digitsMap.put(1, "Thousand");
		digitsMap.put(2, "Million");
		digitsMap.put(3, "Billion");
	}
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        int digits = 0;
        while (num > 0) {
        	int k = num % 1000;
            String str = getText(k);
        	if (digits > 0 && !str.isEmpty()) {
        		str += " " + digitsMap.get(digits) + " ";
        	}
            digits++;
            sb.insert(0, str);
            num /= 1000;
        }

        return sb.toString().trim();
    }

    private String getText(int n) {
    	if (n == 0) return "";

    	StringBuilder sb = new StringBuilder();
    	if (n >= 100) {
    		sb.append(textMap.get(n / 100)).append(" Hundred ");
    		n %= 100;
    	}
        
        if (n < 20) {
            if (n > 0) sb.append(textMap.get(n));
        } else {
            sb.append(textMap.get(n / 10 * 10));
            if (n % 10 != 0) {
                sb.append(" ").append(textMap.get(n % 10));
            }
        }
        
    	return sb.toString().trim();
    }
}
