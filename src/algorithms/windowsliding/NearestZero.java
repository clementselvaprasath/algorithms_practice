package algorithms.windowsliding;

public class NearestZero {

	public static void main(String[] args) {
		int[] a = {0, 6, 0, 1, -2, 3, 4, 0, 0};
		int[] res = nearestZero(a);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}

	private static int[] nearestZero (int[] a) {
		if (a == null) return null;
		int n = a.length;
		int[] res = new int[n];
		
		for (int i = 0; i < n; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		int zero = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				res[i] = 0;
				zero = i;
			} else {
				if (zero >= 0) {
					res[i] = i - zero;
				}
			}
		}
		
		zero = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] == 0) {
				res[i] = 0;
				zero = i;
			} else {
				if (zero >= 0 && zero - i < res[i]) {
					res[i] = zero - i;
				}
			}
		}
		
		return res;
	}
}
