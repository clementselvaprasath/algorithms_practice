package algorithms.dp;

public class EditDistance_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given two strings S and T, determine if they are both one edit distance
	 * apart.
	 * 
	 * Example Given s = "aDb", t = "adb" return true
	 */
	public static boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null || s.equals(t)) return false;
    
    	char[] a = s.toCharArray();
    	char[] b = t.toCharArray();
    
    	int m = a.length;
    	int n = b.length;
    
    	int[][] f = new int[m + 1][n + 1];
    	for (int i = 0; i <= m; i++) {
    		for (int j = 0; j <= n; j++) {
    			if (i == 0) {
    				f[i][j] = j;
    				continue;
    			}
    			if (j == 0) {
    				f[i][j] = i;
    				continue;
    			}
    								// delete		//add
    			f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
    			if (a[i - 1] == b[j - 1]) {
    				f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
    			} else {
    											// edit
    				f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
    			}
    		}
    	}
    
    	return f[m][n] == 1;
	}
	
	public static boolean isOneEditDistance_Optimal(String s, String t) {
		if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
	    
    	char[] a = s.toCharArray();
    	char[] b = t.toCharArray();
    
    	int m = a.length;
    	int n = b.length;
    
    	int i = 0, j = 0, dif = 0;;
    	while (i < m && j < n) {
    		if (a[i] != b[j]) { 
				dif++;
				if (m - i == n - j) {
	    			i++;
	    			j++;
	    		} else if (m - i > n - j){
	    			i++;
	    		} else {
	    			j++;
	    		}
			} else {
				i++;
				j++;
			}
    	}
    
    	dif += m - i + n - j;
    	
    	return dif == 1;
	}
}
