package algorithms.dfs_bfs;

import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * 
 * @author qz
 *
 */
public class Subsets_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        
		
		return null;
    }
	
	
	private static void printList(List<Integer> list) {
		System.out.print(list.get(0));
		for(int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.println();
	}
}
