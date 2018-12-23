package algorithms.arrayandlist.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

1
1,2	2,1



 * @author qz
 *
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// back tracking, preferred
	public List<List<Integer>> permute_backtracking(int[] nums) {
    	if (nums.length == 0) return new ArrayList<>(); 
    	List<List<Integer>> res = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
    	if (list.size() == nums.length) {
    		res.add(new ArrayList<>(list));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (visited[i]) {
    			continue;
    		}

    		list.add(nums[i]);
    		visited[i] = true;
    		permute(nums, visited, list, res);
    		visited[i] = false;
    		list.remove(list.size() - 1);
    	}
    }
	
    // leverage java api
	public List<List<Integer>> permute_api(int[] nums) {
    	if (nums.length == 0) return new ArrayList<>(); 
        return permute(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> permute(int[] nums, int start, int end) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (start == end) {
    		res.add(Arrays.asList(nums[start]));
    		return res;
    	}

    	List<List<Integer>> pre = permute(nums, start + 1, end);
    	for (List<Integer> list : pre) {
    		for (int i = 0; i < list.size(); i++) {
    			List<Integer> nlist = new ArrayList<>(list);
    			nlist.add(i, nums[start]);
    			res.add(nlist);
    		}
    		List<Integer> nlist = new ArrayList<>(list);
			nlist.add(nums[start]);
			res.add(nlist);
    	}

    	return res;
    }
}
