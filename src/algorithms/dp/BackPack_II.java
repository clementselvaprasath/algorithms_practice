package algorithms.dp;

public class BackPack_II {

	public static void main(String[] args) {
		int[] a = {2, 3, 5, 7};
		int[] v = {1, 5, 2, 4};
		int m = 10;
		System.out.println(backPackII(m, a, v));
	}

	/*
	 * Given n items with size Ai and value Vi, and a backpack with size m.
	 * What's the maximum value can you put into the backpack?
	 * 
	 * Example Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and
	 * a backpack with size 10. The maximum value is 9.
	 * 
	 * You can only use each item once.
	 * 
	 * Challenge O(n x m) memory is acceptable, can you do it in O(m) memory?
	 * 
	 */
	
	// f(i, w) = max {f(i - 1, w), f(i - 1, w - A[j]) + V[j] | w >= A[j]}
	public static int backPackII(int m, int[] A, int[] V) {
		if (A == null || A.length == 0 || V == null || V.length == 0 
				|| A.length != V.length || m == 0) {
			return 0;
		}
        
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 1; i <= m; i++) {
        	f[i] = -1; 
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
            	if (j >= A[i - 1] && f[j - A[i - 1]] >= 0) {
            		f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
            	}
            }
        }
        
        int max = 0;
        for (int i = 0; i <= m; i++) {
        	max = Math.max(max, f[i]);
        }
        
        return max;
	}
}
