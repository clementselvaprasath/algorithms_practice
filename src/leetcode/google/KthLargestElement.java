package leetcode.google;

import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element. For
 * example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author qz
 *
 */
public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Random rand = new Random();

	public int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		int pos = -1;
		int p = pos - start + 1;
		while (p != k) {
			if (p > k) {
				end = pos - 1;
			} else {
				start = pos + 1;
				k = k - p;
			}
			pos = partition(nums, start, end);
			p = pos - start + 1;
		}

		return nums[pos];
	}

	private int partition(int[] nums, int start, int end) {
		// System.out.println("start: " + start + ", end: " + end);
		int r = rand.nextInt(end - start + 1) + start;
		swap(nums, r, end);
		int i = start, j = 0, p = nums[end];
		for (j = start; j < end; j++) {
			if (nums[j] >= p) {
				swap(nums, i++, j);
			}
		}
		swap(nums, i, end);
		return i;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
