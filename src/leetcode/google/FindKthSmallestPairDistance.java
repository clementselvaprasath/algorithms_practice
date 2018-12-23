package leetcode.google;

import java.util.Arrays;

/**
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B.
 * 
 * Example 1:
	Input:
	nums = [1,3,1]
	k = 1
	Output: 0 
	Explanation:
	Here are all the pairs:
	(1,3) -> 2
	(1,1) -> 0
	(3,1) -> 2
	Then the 1st smallest distance pair is (1,1), and its distance is 0.
	Note:
	2 <= len(nums) <= 10000.
	0 <= nums[i] < 1000000.
	1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * 
 * @author qz
 *
 */
public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	
	// binary search
	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = nums[n - 1] - nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        int mid;
        while (min < max) {
            mid = min + (max - min) / 2;
            int pairs = countPairs(nums, mid);
            if (pairs < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        return min;
    }
    
    private int countPairs(int[] nums, int val) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findUpperBound(nums, i, n - 1, nums[i] + val) - i - 1;
        }
        
        return res;
    }
    
    private int findUpperBound(int[] nums, int start, int end, int target) {
        if (nums[end] <= target) return end + 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
