package algorithms.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/subsets/
 * @author qz
 *
 */
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsets_iterative(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> list : res) {
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(nums[i]);
                tmp.add(nlist);
            }
            res.addAll(tmp);
        }
        
        
        return res;
    }
	
	public List<List<Integer>> subsets_recursive(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void findSubsets(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(path);
        for (int i = start; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>(path);
            list.add(nums[i]);
            findSubsets(nums, i + 1, list, res);
        }
    }
}
