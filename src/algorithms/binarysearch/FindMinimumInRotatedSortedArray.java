package algorithms.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 * @author qz
 *
 */
public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
		int[] n = {3,4,5,1,2};
		
		System.out.println(s.findMin(n));
	}

	// without duplicates
	public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] <= nums[1] && nums[0] <= nums[n - 1]) return nums[0];
        int start = 0, end = n - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] >= nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
	
	// contains duplicates
	/*
	 * in the worst case, which all elements are the same, the time complexity will be O(n)
	 */
	public int findMin_withDuplicates(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > nums[i]) return nums[i];
        }
        
        return pre;
    }
}
