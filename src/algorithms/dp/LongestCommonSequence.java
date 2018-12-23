package algorithms.dp;

public class LongestCommonSequence {

	public static void main(String[] args) {
		char[] x = new char[] {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char[] y = new char[] {'B', 'D', 'C', 'A', 'B', 'A'};
		System.out.println(getLongestCommonSequence_BottomUp(x, y));
	}

	public static String getLongestCommonSequence_BottomUp(char[] x, char[] y) {
		if(x.length == 0 || y.length == 0) return "";
		int m = x.length, n = y.length; 
		String[][] t = new String[m + 1][n + 1];
		// init
		for(int i = 0; i < t.length; i++) {
			t[i][0] = "";
		}
		for(int j = 0; j < t[0].length; j++) {
			t[0][j] = "";
		}
		for(int i = 1; i < t.length; i++) {
			for(int j = 1; j < t[i].length; j++) {
				if(x[i - 1] == y[j - 1]) {
					t[i][j] = t[i - 1][j - 1] + x[i - 1];
				} else {
					if(t[i - 1][j].length() > t[i][j - 1].length()) {
						t[i][j] = t[i - 1][j];
					} else {
						t[i][j] = t[i][j - 1];
					}
				}
			}
		}
		
		return t[m][n];
	}
}
