package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/majority-number/
 * 
 * Given an array of integers, the majority number is the number that occurs
 * more than half of the size of the array. Find it.
 * 
 * Notice You may assume that the array is non-empty and the majority number
 * always exist in the array.
 * 
 * 
 * Example Given [1, 1, 1, 1, 2, 2, 2], return 1
 * 
 * Challenge O(n) time and O(1) extra space
 * 
 * @author qz
 *
 */
public class MajorityNumber {

	public int majorityNumber(List<Integer> nums) {
		// write your code here
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0, res = 0;
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
			if (map.get(n) > max) {
				res = n;
				max = map.get(n);
			}
		}

		return res;
	}

	/*
	 * Boyer–Moore majority vote algorithm (Vote algorithm)
	 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
	 * 
	 */
	public int majorityNumber_ConstantSpace(List<Integer> nums) {
		int count = 0, candidate = -1;
		for (int i = 0; i < nums.size(); i++) {
			if (count == 0) {
				candidate = nums.get(i);
				count = 1;
			} else if (candidate == nums.get(i)) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
