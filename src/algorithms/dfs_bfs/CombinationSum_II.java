package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

public class CombinationSum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(candidates, 0, new ArrayList<Integer>(), target, res);
		return res;
	}

	private void findCombinations(int[] nums, int start, List<Integer> path, int target, List<List<Integer>> res) {
		if (target == 0) {
			res.add(path);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}

			if (target - nums[i] < 0)
				break;
			List<Integer> np = new ArrayList<>(path);
			np.add(nums[i]);
			findCombinations(nums, i + 1, np, target - nums[i], res);
		}
	}
}
