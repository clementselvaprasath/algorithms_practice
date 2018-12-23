package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * 
 * @author qz
 *
 */

public class FourSum {

	/**
	 * find sub problem of size - 1, do two sum when size == 2
	 */
	List<List<Integer>> res = new ArrayList<>();
	int K = 4;

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums.length < 4)
			return res;
		Arrays.sort(nums);
		fourSum(nums, 0, target, new ArrayList<Integer>());
		return res;
	}

	private void fourSum(int[] nums, int index, int target, List<Integer> path) {
		// do a quick two sum
		if (path.size() == 2) {
			twoSum(nums, index, target, path);
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			List<Integer> npath = new ArrayList<>(path);
			npath.add(nums[i]);
			fourSum(nums, i + 1, target - nums[i], npath);
		}
	}

	private void twoSum(int[] nums, int index, int target, List<Integer> path) {
		int left = index, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> npath = new ArrayList<>(path);
				npath.add(nums[left]);
				npath.add(nums[right]);
				res.add(npath);
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1])
					left++;
				while (left < right && nums[right] == nums[right + 1])
					right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}

}
