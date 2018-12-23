package leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author qz
 *
 */
public class SubSets_I {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void find(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
    	res.add(path);
    	for (int i = start; i < nums.length; i++) {
    		List<Integer> nl = new ArrayList<>(path);
    		nl.add(nums[i]);
    		find(nums, i + 1, nl, res);
    	}
    }
}
