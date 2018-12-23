package algorithms.dp;

public class BackPack_VI {

	public static void main(String[] args) {
		int[] a = {1, 2, 4};
		int T = 4;
		System.out.println(backPack(T, a));
	}
	
	/*
	 * Given n items with size Ai, an integer m denotes the size of a backpack.
	 * How many ways you can fill the backpack exactly equal to T?
	 * 
	 * Example If we have 4 items with size [1, 2, 3, 3, 7], the backpack target
	 * is 7, we can select [1, 3, 3] or [7] so that we fill the backpack with
	 * target 7. Elements in A can be multiple times.
	 * 
	 * Challenge O(n x m) time and O(m) memory.
	 * 
	 * O(n x m) memory is also acceptable if you do not know how to optimize
	 * memory.
	 */
	// f(n) = sum (f(n - A[i]))
	// f(i, w) = sum (f(i - 1, w - A[j]) | w >= A[j], 0 <= j <= n - 1)
	public static int backPack(int T, int[] A) {
		if (A == null || A.length == 0 || T == 0)
			return 0;

		int n = A.length;

		int[] f = new int[T + 1];
		f[0] = 1;
		for (int i = 1; i <= T; i++) {
			for (int j = 0; j < n; j++) {
				if (A[j] <= i) {
					f[i] += f[i - A[j]];
				}
			}
		}
		
		return f[T];
	}
}
