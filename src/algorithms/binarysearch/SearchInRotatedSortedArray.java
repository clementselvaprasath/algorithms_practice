package algorithms.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 * @author qz
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	}

        	if (nums[mid] > nums[start]) {
        		if (nums[mid] >= target && target >= nums[start]) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else {
        		if (nums[mid] <= target && target <= nums[end]) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }
        if (nums[start] == target) {
        	return start;
        } else if (nums[end] == target) {
        	return end;
        } else {
        	return -1;
        }
    }
}
