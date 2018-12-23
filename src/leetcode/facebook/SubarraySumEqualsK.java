package leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 * @author qz
 *
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i : nums) {
        	sum += i;
        	if (map.containsKey(sum - k)) {
        		res += map.get(sum - k);
        	}
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
