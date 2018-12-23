package leetcode.google;

public class MinimumPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a set of integers, write a function to divide it into two sets S1
	 * and S2 such that the absolute difference between their sums is minimum.
	 * 
	 * If there is a set S with n elements, then if we assume Subset1 has m
	 * elements, Subset2 must have n-m elements and the value of
	 * abs(sum(Subset1) – sum(Subset2)) should be minimum.
	 * 
	 * Given nums = [1, 6, 11, 5], return 1
	 * 
	 * // Subset1 = [1, 5, 6], sum of Subset1 = 12 
	 * // Subset2 = [11], sum of Subset2 = 11 
	 * // abs(11 - 12) = 1
	 */
	
	public static int findMin(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int medium = sum / 2;
        boolean[] f = new boolean[medium + 1];
        f[0] = true;
        for (int i = 1; i <= medium; i++) {
            f[i] = false;
        }
        
        // f[i][w] = f[i - 1][w] || w >= A[i - 1] && f[i - 1][w - A[i - 1]]
        for (int j = 1; j <= n; j++) {
            for (int i = medium; i >= 0; i--) {
                f[i] = f[i] || i >= A[j - 1] && f[i - A[j - 1]];
            }
        }
        
        int max = 0;
        for (int i = medium; i >= 0; i--) {
            if (f[i]) {
                max = i;
                break;
            }
        }
        
        return Math.abs(sum - max * 2);
    }
}
