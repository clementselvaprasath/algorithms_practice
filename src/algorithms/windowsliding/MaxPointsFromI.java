package algorithms.windowsliding;

public class MaxPointsFromI {

	public static void main(String[] args) {
		int[] a = { 5, 6, 4, 2, 8, 3, 1 };
		int k = 3, i = 3;
		System.out.println(getMaxPoint(a, k, i));
	}

	private static int getMaxPoint(int[] a, int k, int i) {
		if (a == null || a.length == 0) return 0;
		int n = a.length;
		if (i < 0 || i >= n) return 0;
		
		int l = Math.max(0, i - k + 1);
		int r = Math.min(n - 1, i + k - 1);
		int max = 0;
		for (int p = l; p <= r; p++) {
			if (p - l + 1 <= k) {
				max += a[p];
			} else {
				int temp = max - a[l] + a[p];
				max = Math.max(max, temp);
				l++;
			}
		}
		
		return max;
	}
}
