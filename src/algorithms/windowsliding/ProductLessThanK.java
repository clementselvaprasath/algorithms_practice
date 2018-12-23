package algorithms.windowsliding;

public class ProductLessThanK {

	public static void main(String[] args) {
		int[] a = {1, 9, 2, 8, 6, 4, 3};
		int k = 100;
		System.out.println(findProductLessThanK(a, k));
	}

	private static int findProductLessThanK (int[] a, int k) {
		if (a == null || a.length == 0) return 0;
		int n = a.length;
		int l = 0, r = 0, count = 0, prod = 1;
		while (l < n && r < n) {
			prod *= a[r];
			while (l < r && prod >= k) {
				prod /= a[l++];
			}
			if (prod < k) {
				count += 1 + r - l;
				r++;
			}
		}
		return count;
	}
}
