package leetcode.google;

public class BigIntegerAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given two non-negative integers num1 and num2 represented as string,
	 * return the sum of num1 and num2.
	 * 
	 * Notice 
	 * The length of both num1 and num2 is < 5100. 
	 * Both num1 and num2 contains only digits 0-9. 
	 * Both num1 and num2 does not contain any leading zero. 
	 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
	 * 
	 * Example Given num1 = "123", num2 = "45" return "168"
	 */
	
	public static String addStrings(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int n1 = c1.length;
        int n2 = c2.length;
    
        StringBuilder sb = new StringBuilder();
        int i, j;
        int add = 0;
        for (i = n1 - 1, j = n2 - 1; i >= 0 && j >= 0; i--, j--) {
        	int sum = (c1[i] - '0') + (c2[j] - '0') + add;
        	sb.append(sum % 10);
        	add = sum / 10;
        }
        if (j > 0) {
        	c1 = c2;
        }
        for (i = Math.max(i, j); i >= 0; i--) {
    		int v = c1[i] - '0' + add;
    		sb.append(v % 10);
    		add = v / 10;
    	}
    	if (add > 0) {
    	    sb.append(add);
    	}
    	
    	return sb.reverse().toString();
    }
}
