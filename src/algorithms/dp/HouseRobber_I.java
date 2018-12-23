package algorithms.dp;

public class HouseRobber_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security
	 * system connected and it will automatically contact the police if two
	 * adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 * 
	 * Example Given [3, 8, 4], return 8.
	 * 
	 * Challenge O(n) time and O(1) memory.
	 */
	public static long houseRobber(int[] A) {
		if (A == null) return 0l;
        int n = A.length;
        if (n == 0) return 0l;
        if (n == 1) return (long) A[0];
        
        long[] f = new long[2];
        f[0] = 0l;
        f[1] = (long)A[0];
        for (int i = 1; i < n; i++) {
            if (f[0] + (long) A[i] > f[1]) {
                long temp = f[1];
                f[1] = f[0] + (long) A[i];
                f[0] = temp;
            } else {
                f[0] = f[1];
            }
        }
        
        return f[1];
	}
}
