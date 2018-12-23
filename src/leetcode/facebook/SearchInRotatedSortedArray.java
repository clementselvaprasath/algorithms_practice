package leetcode.facebook;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * 
 * @author qz
 *
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {

	}

	public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                if (nums[mid] <= nums[end]) {
                    end = mid - 1;
                } else {
                    if (target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else if (nums[mid] < target) {
                if (nums[mid] >= nums[start]) {
                    start = mid + 1;
                } else {
                    if (target >= nums[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
