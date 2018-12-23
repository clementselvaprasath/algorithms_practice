package algorithms.dp;

public class BackPack_V {

	public static void main(String[] args) {
		int[] a = {1,2,3,3,7};
		System.out.println(backPack(7, a));
	}

	/*
	 * Given n items with size Ai, an integer m denotes the size of a backpack.
	 * How many ways you can fill the backpack exactly equal to T?
	 * 
	 * Example If we have 4 items with size [1, 2, 3, 3, 7], the backpack target
	 * is 7, we can select [1, 3, 3] or [7] so that we fill the backpack with
	 * target 7. Elements in A can only be used once.
	 * 
	 * Challenge O(n x m) time and O(m) memory.
	 * 
	 * O(n x m) memory is also acceptable if you do not know how to optimize
	 * memory.
	 */
	public static int backPack(int T, int[] A) {
		if (A == null || A.length == 0 || T == 0)
			return 0;

		int n = A.length;

		int[] f = new int[T + 1];
		f[0] = 1;
		for (int i = 1; i < T; i++) {
			f[i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = T; j >= 0; j--) {
				if (j >= A[i - 1]) {
					f[j] += f[j - A[i - 1]];
				}
			}
		}
		
		return f[T];
	}
}
