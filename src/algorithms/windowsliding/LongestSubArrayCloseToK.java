package algorithms.windowsliding;

public class LongestSubArrayCloseToK {

	public static void main(String[] args) {
		int[] a = {1, 2, 1, 0, 1, 1, 0};
		int k = 4;
		
		System.out.println(longestSubArrayCloseToK(a, k));
	}

	private static int longestSubArrayCloseToK (int[] a, int k) {
		if (a == null || a.length == 0) return 0;
		int n = a.length;
		int start = 0, max = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum <= k) {
				max = Math.max(max, i - start + 1);
			} else {
				sum -= a[start];
				start++;
			}
		}
		
		return max;
	}
}
