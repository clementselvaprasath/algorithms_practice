package leetcode.google;

import java.util.Arrays;

/**
 * http://lintcode.com/en/problem/create-maximum-number/
 * 
 * @author qz
 *
 */
public class CreateMaximumNumber {

	public static void main(String[] args) {
		int[] a = { 9, 1, 2, 5, 8, 3 };
		int[] b = { 6, 7 };
		int[] b1 = { 6, 0, 4 };

	}

	/*
	 * Given two arrays of length m and n with digits 0-9 representing two
	 * numbers. Create the maximum number of length k <= m + n from digits of
	 * the two. The relative order of the digits from the same array must be
	 * preserved. Return an array of the k digits. You should try to optimize
	 * your time and space complexity.
	 * 
	 * Have you met this question in a real interview? Yes Example Given nums1 =
	 * [3, 4, 6, 5], nums2 = [9, 1, 2, 5, 8, 3], k = 5 return [9, 8, 6, 5, 3]
	 * 
	 * Given nums1 = [6, 7], nums2 = [6, 0, 4], k = 5 return [6, 7, 6, 0, 4]
	 * 
	 * Given nums1 = [3, 9], nums2 = [8, 9], k = 3 return [9, 8, 9]
	 * 
	 * 
	 */

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		if (nums1 == null && nums2 == null || nums1 != null && nums1.length < k && nums2 == null
				|| nums2 != null && nums2.length < k && nums1 == null || nums1.length + nums2.length < k || k == 0) {
			return res;
		}

		int m = nums1.length;
		int n = nums2.length;

		int min = Math.min(k, m);
		for (int i = Math.max(0, k - n); i <= min; i++) {
			int[] tmp = merge(findMax(nums1, i), findMax(nums2, k - i), k);
			if (isGreater(tmp, 0, res, 0)) {
				res = tmp;
			}
		}

		return res;
	}

	private int[] merge(int[] n1, int[] n2, int k) {
		if (n1 == null)
			return n2;
		else if (n2 == null)
			return n1;

		int[] ans = new int[k];
		int i = 0, j = 0, r = 0;
		for (r = 0; r < k; r++) {
			ans[r] = isGreater(n1, i, n2, j) ? n1[i++] : n2[j++];
		}
		return ans;
	}

	private boolean isGreater(int[] n1, int i, int[] n2, int j) {
		for (; i < n1.length && j < n2.length; i++, j++) {
			if (n1[i] > n2[j])
				return true;
			if (n1[i] < n2[j])
				return false;
		}
		return i != n1.length;
	}

	private int[] findMax(int[] n, int k) {
		if (k == 0) {
			return null;
		}
		int[] ans = new int[k];
		int l, r;
		int i = 0;
		for (l = 0, r = n.length - k; r < n.length; r++) {
			int max = 0;
			int j = l;
			while (l <= r) {
				if (n[l] > max) {
					j = l;
					max = n[l];
				}
				l++;
			}
			ans[i++] = n[j];
			l = j + 1;
		}

		return ans;
	}
}
