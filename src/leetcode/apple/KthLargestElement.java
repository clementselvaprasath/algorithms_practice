package leetcode.apple;

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
        int n = nums.length, start = 0, end = n - 1;
        int p = -1;
        int q = p - start + 1;
        while (q != k) {
            if (q > k) {
                end = p - 1;
            } else {
                start = p + 1;
                k = k - q;
            }
            p = partition(nums, start, end);
            q = p - start + 1;
        }
        
        return nums[p];
    }
    private int partition(int[] nums, int start, int end) {
        int r = rand.nextInt(end - start + 1) + start;
        swap(nums, r, end);
        int i = start, p = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] >= p) swap(nums, i++, j);
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
