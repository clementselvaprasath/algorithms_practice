package algorithms.dp;

public class CoinsInALine_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * There are n coins in a line. Two players take turns to take one or two
	 * coins from right side until there are no more coins left. The player who
	 * take the last coin wins.
	 * 
	 * Could you please decide the first play will win or lose?
	 * 
	 * Example n = 1, return true.
	 * 
	 * n = 2, return true.
	 * 
	 * n = 3, return false.
	 * 
	 * n = 4, return true.
	 * 
	 * n = 5, return true.
	 * 
	 * Challenge O(n) time and O(1) memory
	 */
	public static boolean firstWillWin(int n) {
		if (n == 0) return false;
        if (n == 1) return true;
        
        boolean f0 = false, f1 = true;
        boolean res = false;
        for (int i = 2; i <= n; i++) {
            res = (!f0 || !f1);
            f0 = f1;
            f1 = res;
        }
        
        return res;
	}
}
