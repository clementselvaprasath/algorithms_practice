package leetcode.google;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * There is an integer array which has the following features:
	 * 
	 * The numbers in adjacent positions are different. A[0] < A[1] &&
	 * A[A.length - 2] > A[A.length - 1]. We define a position P is a peek if:
	 * 
	 * A[P] > A[P-1] && A[P] > A[P+1] Find a peak element in this array. Return
	 * the index of the peak.
	 * 
	 * Notice
	 * It's guaranteed the array has at least one peak. 
	 * The array may contain multiple peeks, find any of them. 
	 * The array has at least 3 numbers in it.
	 * 
	 * Example Given [1, 2, 1, 3, 4, 5, 7, 6]
	 * 
	 * Return index 1 (which is number 2) or 6 (which is number 7)
	 * 
	 * Challenge Time complexity O(logN)
	 * 
	 */
	public static int findPeak(int[] A) {
		if (A == null || A.length < 3) return 0;
        int n = A.length;
        int start = 0, end = A.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid > 0 && mid < n - 1) {
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                }
                
                if (A[mid - 1] > A[mid + 1]) {
                    end = mid - 1;
                }
                if (A[mid - 1] <= A[mid + 1]) {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
	}
}
