package algorithms.dp;

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
	 * number on it represented by array nums. You are asked to burst all the
	 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
	 * nums[right] coins. Here left and right are adjacent indices of i. After
	 * the burst, the left and right then becomes adjacent.
	 * 
	 * Find the maximum coins you can collect by bursting the balloons wisely. -
	 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you
	 * can not burst them. - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
	 * 
	 * 
	 * Example Given [4, 1, 5, 10] Return 270
	 * 
	 * nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20.
	 * nums = [4, 5, 10] burst 5, get coins 4 * 5 * 10 = 200.
	 * nums = [4, 10] burst 4, get coins 1 * 4 * 10 = 40.
	 * nums = [10] burst 10, get coins 1 * 10 * 1 = 10.
	 * 
	 * Total coins 20 + 200 + 40 + 10 = 270
	 */
	
	//let f(i, j) is the total coins can be collected where balloons from i + 1 to j - 1 are burst.
	// f(i, j) = max { f(i, k) + f(k, j) + A[i] * A[k] * A[j] | i < k < j }
	public static int maxCoins(int[] nums) {
		if (nums == null | nums.length == 0) return 0;
        int n = nums.length;
        
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            A[i] = nums[i - 1];
        }
        
        int[][] f = new int[n + 2][n + 2];
        
        for (int l = 3; l <= n + 2; l++) {
            for (int i = 0; i < n - l + 3; i++) {
                int j = i + l - 1;
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[i] * A[k] * A[j]);
                }
            } 
        }
        
        return f[0][n + 1];
	}
}
