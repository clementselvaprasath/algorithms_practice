package algorithms.dp;

import java.util.List;

public class MinimumAdjustmentCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given an integer array, adjust each integers so that the difference of
	 * every adjacent integers are not greater than a given number target.
	 * 
	 * If the array before adjustment is A, the array after adjustment is B, you
	 * should minimize the sum of |A[i]-B[i]|
	 * 
	 * Notice You can assume each number in the array is a positive integer and
	 * not greater than 100.
	 * 
	 * Example Given [1,4,2,3] and target = 1, one of the solutions is
	 * [2,3,2,3], the adjustment cost is 2 and it's minimal.
	 * Return 2.
	 */
	
	/*
	 * i, j, k: i items, j = value after adjustment, k = the value of previous element.
	 * f(i, j): cost of adjusting first i elements and the last element adjust to j.
	 * 
	 * Assume we have an int array A, and target T, after adjustment, we will have 
	 * Array B. The idea is enumerate all possible value of B[i - 2], find out the 
	 * minimum sum of f(i - 1, k) + j - A[i - 1] and j - T <= k <= j + T && k >= 1
	 * value 
	 * f(i, j) = Min { f(i - 1, k) + j - A[i - 1] }
	 * 
	 */
	public static int MinAdjustmentCost(List<Integer> A, int T) {
		if (A == null || A.isEmpty()) return 0;
		
		int n = A.size();
		int[][] f = new int[n + 1][101];

        for (int i = 1; i <= 100; i++) {
            f[1][i] = Math.abs(A.get(0) - i);
        }		
	           // i elements
	    for (int i = 2; i <= n; i++) {
	                // enumerate the current possible value
	        for (int j = 1; j <= 100; j++) {
	            f[i][j] = Integer.MAX_VALUE;
	            for (int k = j - T; k <= j + T; k++) {
	                if (k < 1 || k > 100) continue;
	                f[i][j] = Math.min(f[i][j], Math.abs(j - A.get(i - 1)) + f[i - 1][k]);
	            }
	        }
	    }
	    
	    int min = Integer.MAX_VALUE;
	    for (int i = 1; i <= 100; i++) {
	        min = Math.min(min, f[n][i]);
	    }
	    
	    return min;
    }
}
