package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is:
 * 
 * [
  [7],
  [2, 2, 3]
]
 * 
 * @author qz
 *
 */
public class CombinationSum_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }
    
    private void dfs (int[] candidates, int index, List<Integer> path, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(path);
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                List<Integer> nlist = new ArrayList<>(path);
                nlist.add(candidates[i]);
                dfs(candidates, i, nlist, target - candidates[i], res);
            }
        }
    }
}
