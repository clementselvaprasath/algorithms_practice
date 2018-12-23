package algorithms.other;

import java.util.Arrays;

/**
 * Give an array and a target. We need to find the number of subsets which meet
 * the following conditions: The sum of the minimum value and the maximum value
 * in the subset is less than the target.
 * 
 * Notice The length of the given array does not exceed 50. target <= 100000.
 * 
 * Example Give array = [1,5,2,4,3], target = 4, return 2.
 * 
 * Explanation: Only subset [1],[1,2] satisfy the condition, so the answer is 2.
 * Give array = [1,5,2,4,3],target = 5, return 5.
 * 
 * Explanation: Only subset [1],[2],[1,3],[1,2],[1,2,3] satisfy the condition,
 * so the answer is 5.
 * 
 * @author qz
 *
 */
public class SubsetWithTarget {

	public static void main(String[] args) {
		SubsetWithTarget obj = new SubsetWithTarget();
		int[] nums = {1, 2, 3};
		int target = 7;
		System.out.println(obj.subsetWithTarget(nums, target));
	}

	/**
	 * fix i, consider if the number from i + 1 to j were pick or not.
	 * the result = 1 << count(i + 1, j)
	 * 
	 */
	public long subsetWithTarget(int[] nums, int target) {
		if (nums.length == 0 || target == Integer.MIN_VALUE)
			return 0;
		int n = nums.length;
		Arrays.sort(nums);
		long ans = 0;
		for (int i = 0; i < n && nums[i] * 2 < target; i++) {
			int count = 0;
			int max = target - nums[i];
			for (int j = i + 1; j < n && nums[j] < max; j++) {
				count++;
			}
			ans += ((long) (1l << count));
		}

		return ans;
	}
}
