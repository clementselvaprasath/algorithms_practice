package leetcode.google;

/**
 * Given a sorted array consisting of only integers where every 
 * element appears twice except for one element which appears once. 
 * Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.


 * @author qz
 *
 */
public class SingleElementInASortedArray {

	public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1, mid = 0;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	int v = nums[mid];
        	if (v != nums[mid - 1] && v != nums[mid + 1]) {
        		return v;
        	} else if (v == nums[mid - 1]) {
        		if (mid % 2 == 0) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else {
        		if (mid % 2 == 0) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }
        if (start == 0) {
        	return nums[start];
        } else {
        	return nums[end];
        }
    }
}
