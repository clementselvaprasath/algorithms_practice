package leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Input: [5,2,6,1] Output: [2,1,1,0] Explanation: To the right of 5 there are 2
 * smaller elements (2 and 1). To the right of 2 there is only 1 smaller element
 * (1). To the right of 6 there is 1 smaller element (1). To the right of 1
 * there is 0 smaller element.
 * 
 * @author qz
 *
 */
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int i = 6;

		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(-i));
		System.out.println(Integer.toBinaryString(i & (-i)));
	}

	// binary indexed tree
	public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        
        discretization(nums);
        
        int[] bits = new int[n + 1];
        int[] count = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            count[i] = getSum(bits, nums[i] - 1);
            update(bits, nums[i]);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        
        return res;
    }
    
    private void discretization(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }
    }
    
    private void update(int[] bits, int x) {
        for (int i = x; i < bits.length; i += lowbit(i)) {
            bits[i]++;
        }
    }
    
    private int getSum(int[] bits, int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += bits[i];
        }
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
}
