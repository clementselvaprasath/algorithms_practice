package leetcode.google;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the 
 * list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from
 the very left of the array to the very right. You can only see the k numbers 
 in the window. Each time the sliding window moves right by one position. 
 Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's 
size for non-empty array.
 * @author qz
 *
 */
public class SlidingWindowMedian {

	public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        double[] ans = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
        	if (i < k) {
        		addNumber(max, min, nums[i]);
        	} else {
        		ans[i - k] = getMedian(max, min);
        		removeNumber(max, min, nums[i - k]);
        		addNumber(max, min, nums[i]);
        	}
        }
        ans[n - k] = getMedian(max, min);
        return ans;
    }
    
    private double getMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        return max.size() == min.size()? ((double) max.peek() + (double) min.peek()) / 2 : max.peek();
    }
    
    private void addNumber(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num) {
        max.offer(num);
        min.offer(max.poll());
        while (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
    
    private void removeNumber(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num) {
        if (max.contains(num)) {
            max.remove(num);
        } else {
            min.remove(num);
        }
    }
}
