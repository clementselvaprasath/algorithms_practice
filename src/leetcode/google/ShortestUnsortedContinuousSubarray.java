package leetcode.google;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=.
 * 
 * 
 * @author qz
 *
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray ins = new ShortestUnsortedContinuousSubarray();
		int[] nums = {1,3,5,4,2};
		//System.out.println(ins.findUnsortedSubarray_linear(nums));
		System.out.println(ins.findUnsortedSubarray_constantspace(nums));
	}
	
	// constant space, O(n)
	public int findUnsortedSubarray_constantspace(int[] nums) {
        int n = nums.length;
        
        int i = 0, j = n - 1;
        while (i < n - 1) {
            if (nums[i] > nums[i + 1]) break;
            i++;
        }
        while (j >= 1) {
            if (nums[j] < nums[j - 1]) break;
            j--;
        }
        if (j <= i) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }
        
        int left = n, right = 0;
        for (int k = 0; k < n; k++) {
            if (min < nums[k]) {
                left = k;
                break;
            }
        }
        for (int k = n - 1; k >= 0; k--) {
            if (max > nums[k]) {
                right = k;
                break;
            }
        }
        
        return right > left ? right - left + 1 : 0;
    }
	
//	// O(n), using stack, space O(N)
//	public int findUnsortedSubarray_linear(int[] nums) {
//        int n = nums.length;
//        
//        Stack<Integer> stack = new Stack<>();
//        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
//                left = stack.pop();
//            }
//            if (left != Integer.MAX_VALUE) break;
//            stack.push(i);
//        }
//        stack.clear();
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                right = stack.pop();
//            }
//            if (right != Integer.MIN_VALUE) break;
//            stack.push(i);
//        }
//        
//        return right > left ? right - left + 1 : 0;
//    }

	// O(nlgn)
	public int findUnsortedSubarray(int[] nums) {
        TreeMap<Integer, Integer> ceilingMap = new TreeMap<>();
        TreeMap<Integer, Integer> floorMap = new TreeMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ceilingMap.put(nums[i], ceilingMap.getOrDefault(nums[i], 0) + 1);
            floorMap.put(nums[i], floorMap.getOrDefault(nums[i], 0) + 1);
        }
        
        int i = 0, j = n - 1, smallest = ceilingMap.firstKey(), largest = floorMap.lastKey();
        for (i = 0; i < n; i++) {
            if (nums[i] == smallest) {
                int count = ceilingMap.get(nums[i]);
                if (count == 1) {
                    ceilingMap.remove(nums[i]);
                } else {
                    ceilingMap.put(nums[i], count - 1);
                }
                if (ceilingMap.ceilingKey(smallest) != null) {
                    smallest = ceilingMap.ceilingKey(smallest);
                }
            } else {
                break;
            }
        }
        for (j = n - 1; j >= 0; j--) {
            if (nums[j] == largest) {
                int count = floorMap.get(nums[j]);
                if (count == 1) {
                    floorMap.remove(nums[j]);
                } else {
                    floorMap.put(nums[j], count - 1);
                }
                if (floorMap.floorKey(largest) != null) {
                    largest = floorMap.floorKey(largest);
                }
            } else {
                break;
            }
        }
        return j > i? j - i + 1 : 0;
    }
}
