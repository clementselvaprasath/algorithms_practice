package algorithms.dp;

public class DecodeWay {

	public static void main(String[] args) {
		String str = "0";
		System.out.println(numDecodings(str));
	}

	/*
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public static int numDecodings(String s) {
    	if (s.length() == 0 ) return 0;
        char[] msg = s.toCharArray();
        int n = msg.length;
        
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = 0;
        	int index = msg[i-1] - '0';
        	if (index >= 1 && index <= 9) {
        	    f[i] += f[i-1];
        	}
        	if (i >= 2) {
        	    index = (msg[i-2] - '0') * 10 + index;
            	if (index >= 10 && index <= 26) {
            	    f[i] += f[i-2];
            	}
        	}
        }
        
        return f[n];
    }
}
