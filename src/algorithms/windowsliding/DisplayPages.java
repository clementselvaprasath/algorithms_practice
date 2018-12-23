package algorithms.windowsliding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You’re given an array of CSV strings representing search results. Results are
 * sorted by a score initially. A given host may have several listings that show
 * up in these results. Suppose we want to show 12 results per page, but we
 * don’t want the same host to dominate the results. Write a function that will
 * reorder the list so that a host shows up at most once on a page if possible,
 * but otherwise preserves the ordering. Your program should return the new
 * array and print out the results in blocks representing the pages. Input: An
 * array of csv strings, with sort score number of results per page.
 * 
 * @author qz
 *
 */
public class DisplayPages {

	public static void main(String[] args) {
		int[] ids1 = {1,2,3,4,5,6,7,8,9};
		int[] ids2 = {1,2,2,2,2,2,2,2,2};
		int[] ids3 = {1,2,2,2,3,2,1,2,1};
		int[] ids4 = {3,2,3,2,3,2,3,2,3};

		DisplayPages dp = new DisplayPages();
		printNestedList(dp.displayPages(ids1));
		printNestedList(dp.displayPages(ids2));
		printNestedList(dp.displayPages(ids3));
		printNestedList(dp.displayPages(ids4));
	}

	public List<List<Integer>> displayPages(int[] ids) {
		int size = 3;
		List<List<Integer>> res = new ArrayList<>();
		
		int end = 0, n = ids.length;
		Set<Integer> map = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (map.isEmpty() || !map.contains(ids[i])) {
				map.add(ids[i]);
				swap(ids, end++, i);
			}
		}
		
		List<Integer> page = new ArrayList<>();
		for (int id : ids) {
			page.add(id);
			if (page.size() == size) {
				res.add(page);
				page = new ArrayList<>();
			}
		}
		
		return res;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private static void printNestedList(List<List<Integer>> lists) {
		System.out.println("*------------------------------------------------------*");
		for (List<Integer> list : lists) {
			System.out.print("[ ");
			for (Integer elem : list) {
				System.out.print(elem + ", ");
			}
			System.out.print(" ]");
			System.out.println();
		}
	}
}
