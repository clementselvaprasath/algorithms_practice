package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * @author qz
 *
 */
public class SubSetsWithDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        findSubSets(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void findSubSets(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(path);
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            List<Integer> nPath = new ArrayList<Integer>(path);
            nPath.add(nums[i]);
            findSubSets(nums, i + 1, nPath, res);
        }
    }
}
