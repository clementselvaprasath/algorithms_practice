package algorithms.arrayandlist.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * 
 * @author qz
 *
 */
public class Permutations_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void permute(int[] nums, List<Integer> list, boolean[] visited, List<List<Integer>> res) {
    	if (list.size() == nums.length) {
    		res.add(new ArrayList<>(list));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
    			continue;
    		}
    		list.add(nums[i]);
    		visited[i] = true;
    		permute(nums, list, visited, res);
    		visited[i] = false;
    		list.remove(list.size() - 1);
    	}
    }
}
