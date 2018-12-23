package leetcode.google;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		MedianOfTwoSortedArrays ins = new MedianOfTwoSortedArrays();
		int[] A = {1};
		int[] B = {2,3,4,5,6};
		System.out.println(ins.findMedianSortedArrays_Optimal(A, B));
	}

	/*
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays.
	 * 
	 * Example Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
	 * 
	 * Given A=[1,2,3] and B=[4,5], the median is 3.
	 * 
	 * Challenge The overall run time complexity should be O(log (m+n)).
	 */
	
	public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        if (m == 0 && n == 0) {
            return 0;
        }
        
        int r = (m + n) / 2;
        int[] res = new int[r + 1];
        int j = 0, k = 0;
        for (int i = 0; i <= r; i++) {
            if (j >= m) {
                res[i] = B[k++];
                continue;
            }
            if (k >= n) {
                res[i] = A[j++];
                continue;
            }
            res[i] = A[j] < B[k]? A[j++] : B[k++];
        }
        if ((m + n) % 2 == 1) {
            return res[r];
        } else {
            return (res[r] + res[r - 1]) * 1.0 / 2;
        }
    }
	
	public double findMedianSortedArrays_Optimal(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        if (m == 0 && n == 0) {
            return 0;
        }
        int len = m + n;
        
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) * 1.0 / 2;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    private int findKth(int[] A, int startA, int[] B, int startB, int k) {
        int m = A.length;
        int n = B.length;
        if (startA >= m) {
            return B[startB + k - 1];
        }
        if (startB >= n) {
            return A[startA + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        
        int a = startA + k / 2 - 1 >= m? Integer.MAX_VALUE : A[startA + k / 2 - 1];
        int b = startB + k / 2 - 1 >= n? Integer.MAX_VALUE : B[startB + k / 2 - 1];
        
        int nk = k - k / 2;
        if (a > b) {
            return findKth(A, startA, B, startB + k / 2, nk);
        } else {
            return findKth(A, startA + k / 2, B, startB, nk);
        }
    }
}
