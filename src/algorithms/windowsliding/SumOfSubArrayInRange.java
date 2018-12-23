package algorithms.windowsliding;

public class SumOfSubArrayInRange {

	public static void main(String[] args) {
		int[] a = {4, 9, 11, 6, 2};
		int l = 5, r = 10;
		System.out.println(findNumOfSubArrays(a, l, r));
		
		int[] b = {2, 0, 11, 3, 0};
		l = 1; 
		r = 10;
		System.out.println(findNumOfSubArrays(b, l, r));
	}
	
	private static int findNumOfSubArrays (int[] a, int l, int r) {
		int res = 0, exc = 0, inc = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[i] > r) {
				res += (count(inc) - count(exc));
				exc = 0;
				inc = 0;
			} else if (a[i] < l) {
				exc++;
				inc++;
			} else {
				res -= count(exc);
				exc = 0;
				inc++;
			}
		}
		
		res += (count(inc) - count(exc));
		
		return res;
	}

	private static int count(int n) {
		return n * (n + 1) /2;
	}
}
