package algorithms;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, -7};
		int[] arr1 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, -7};
		int[] arr2 = {-13, -3, -25, -20, -3, -16, -23, -18, -20, -7, -12, -5, -22, -15, -1, -7};
        int[] arr3 = {-1, -2};	
        
		Tuple t = findMaximumSubArray(arr, 0, arr.length-1);
		Tuple t1 = findMaximumSubArrayLinear(arr1);
		Tuple t2 = findMaximumSubArrayLinear(arr3);
		System.out.println("Divde-and-conquer - Low: " + t.low + ", high: " + t.high + ", total: " + t.total);
		System.out.println("Linear time - Low: " + t1.low + ", high: " + t1.high + ", total: " + t1.total);
		System.out.println("Linear time - Low: " + t2.low + ", high: " + t2.high + ", total: " + t2.total);
	}
	
	public static Tuple findMaximumSubArrayLinear(int[] a) {
		if (a.length == 0) return new Tuple(0, 0, 0);
		if (a.length == 1) return new Tuple(0, 0, a[0]);
		
		int max = a[0];
		int max_here = a[0];
		int low = 0, high = 0;
		
		for(int i = 0; i < a.length; i++) {
			if (max_here + a[i] >= a[i]) {
				max_here += a[i];
			} else {
				max_here = a[i];
				low = i;
			}
			
			if (max_here >= max) {
				max = max_here;
				high = i;
			}
		}
		
		return new Tuple(low, high, max);
	}
	
	public static Tuple findMaximumSubArray (int[] a, int low, int high) {
		if (a.length == 0) return new Tuple(0,0,0);
		if (low == high) {
			return new Tuple(low,high,a[low]);
		}
		int mid = (high + low) / 2;

		Tuple left = findMaximumSubArray(a, low, mid);
		Tuple right = findMaximumSubArray(a, mid + 1, high);
		Tuple cross = findCrossMaximumSubArray(a, low, mid, high);

		if (left.total >= right.total && left.total >= cross.total) return left;
		else if (right.total >= left.total && right.total >= cross.total) return right;
		else return cross;
	}

	public static Tuple findCrossMaximumSubArray(int[] a, int low, int mid, int high) {
		if (low == high) return new Tuple(low, high, a[low]);
		int left_sum = Integer.MIN_VALUE;
		int left = 0;
		int max_low = low;
		for(int i = mid; i >= low; i--) {
			left += a[i];
			if (left > left_sum) {
				left_sum = left;
				max_low = i;
			}
		}

		int right_sum = Integer.MIN_VALUE;
		int right = 0;
		int max_high = high;
		for(int i = mid + 1; i <= high; i++) {
			right += a[i];
			if (right > right_sum) {
				right_sum = right;
				max_high = i;
			}
		}

		return new Tuple(max_low, max_high, left_sum + right_sum);
	}
}