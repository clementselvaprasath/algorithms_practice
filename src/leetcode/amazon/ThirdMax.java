package leetcode.amazon;

import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead. Example 3: Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number. Both numbers with value 2 are both considered as second
 * maximum.
 * 
 * @author qz
 *
 */
public class ThirdMax {

	public int thirdMax(int[] nums) {
		int k = 3;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int n : nums) {
			if (!q.contains(n)) {
				q.offer(n);
				if (q.size() > k) {
					q.poll();
				}
			}
		}
		if (q.size() == k)
			return q.peek();

		int ans = q.poll();
		while (!q.isEmpty()) {
			ans = q.poll();
		}

		return ans;
	}
}
