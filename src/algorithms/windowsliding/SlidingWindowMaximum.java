package algorithms.windowsliding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given an array nums, there is a sliding window of size k which is moving
	 * from the very left of the array to the very right. You can only see the k
	 * numbers in the window. Each time the sliding window moves right by one
	 * position.
	 * 
	 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	 * 
	 * Window position                Max
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7

	 * 
	 * Therefore, return the max sliding window as [3,3,5,5,6,7].
	 * 
	 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size
	 * for non-empty array.
	 * 
	 * Follow up: Could you solve it in linear time?
	 * 
	 */
	
	public int[] maxSlidingWindow_nlogk (int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        res[0] = map.lastKey();
        for (int i = k; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i - k]) == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            }
            res[i - k + 1] = map.lastKey();
        }
        
        return res;
    }
	
	public int[] maxSlidingWindow_Linear(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> deque = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst();
                if (nums[i - k + 1] == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
        }
        
        return res;
    }
}
