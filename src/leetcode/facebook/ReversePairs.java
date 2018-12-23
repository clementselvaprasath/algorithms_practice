package leetcode.facebook;

import java.util.Arrays;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
 * @author qz
 *
 */
public class ReversePairs {

	public static void main(String[] args) {
		ReversePairs rp = new ReversePairs();
		int[] n = {1,3,2,3,1};
		
		System.out.println(rp.reversePairs(n));
	}

	
	
	// binary indexed tree
	public int reversePairs(int[] nums) {
        int n = nums.length;
        
        int[] bits = new int[n + 1];
        
        long[] nums2 = new long[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = (long)nums[i];
        }
        Arrays.sort(nums2);
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            
            int idx1 = Arrays.binarySearch(nums2, 2l * curr + 1);
            ans += getSum(bits, (idx1 < 0 ? -(idx1 + 1) : idx1) + 1);

            int idx2 = Arrays.binarySearch(nums2, curr);
            update(bits, idx2 + 1);
        }
        
        return ans;
    }
    
    private void update(int[] bits, int x) {
        for (int i = x; i >= 1; i -= lowbit(i)) {
            bits[i]++;
        }
    }
    
    private int getSum(int[] bits, int x) {
        int sum = 0;
        for (int i = x; i < bits.length; i += lowbit(i)) {
            sum += bits[i];
        }
        
        return sum;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
	
}
