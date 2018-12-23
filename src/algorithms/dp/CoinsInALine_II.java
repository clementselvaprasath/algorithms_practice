package algorithms.dp;

public class CoinsInALine_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * There are n coins with different value in a line. Two players take turns
	 * to take one or two coins from left side until there are no more coins
	 * left. The player who take the coins with the most value wins.
	 * 
	 * Could you please decide the first player will win or lose?
	 * 
	 * Example Given values array A = [1,2,2], return true.
	 * 
	 * Given A = [1,2,4], return false.
	 */
	public static boolean firstWillWin(int[] v) {
		if (v == null || v.length == 0 || v.length <= 2) return true;
        int n = v.length;
        //reverse v
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = v[i];
            v[i] = v[j];
            v[j] = temp;
            i++;
            j--;
        }
        int[] f = new int[n + 1];
        f[1] = v[0];
        f[2] = v[1];

        for (i = 2; i <= n; i++) {
            f[i] = Math.max(v[i-1] - f[i - 1], v[i - 1] + v[i - 2] - f[i - 2]);
        }
        
        return f[n] >= 0;
	}
}
