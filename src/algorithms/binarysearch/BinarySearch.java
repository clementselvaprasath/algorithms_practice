package algorithms.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] i = {1, 3, 4, 5, 6, 6, 7, 10};
		System.out.println(findValue_I(i, 10));
		
		int[] ii = {1, 3, 3, 5, 5, 7, 7, 10};
		System.out.println(findValue_II(ii, 6));
		
		int[] iii = {1, 3, 4, 4, 6, 6, 8, 10};
		System.out.println(findValue_III(iii, 5));
	}

	/**
	 * Find the value equals to val
	 * 
	 * @param a
	 * @param val
	 * @return
	 */
	public static int findValue_I (int[] a, int val) {
		int n = a.length;
		int start = 0, end = n - 1, mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (a[mid] == val) {
				return mid;
			}
			if (a[mid] < val) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		// if not found
		return -1;
	}
	
	/**
	 * Find the maximum value smaller than v;
	 * 
	 * @param a
	 * @param v
	 * @return
	 */
	public static int findValue_II(int[] a, int v) {
		int n = a.length;
		int start = 0, end = n - 1, mid = 0;
		int max = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (a[mid] >= v) {
				end = mid - 1;
			} else {
				max = mid;
				start = mid + 1;
			}
		}
		
		return max;
	}
	
	/**
	 * find the minimum value greater than v;
	 * 
	 * @param a
	 * @param v
	 * @return
	 */
	public static int findValue_III(int[] a, int v) {
		int n = a.length;
		int start = 0, end = n - 1, mid = 0;
		int min = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (a[mid] > v) {
				min = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return min;
	}
}
