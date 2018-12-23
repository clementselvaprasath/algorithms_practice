package algorithms.arrayandlist.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author qz
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        generate(n, 1, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void generate(int n, int start, int k, List<Integer> list, List<List<Integer>> res) {
    	if (k == 0) {
    		res.add(new ArrayList<>(list));
    		return;
    	}

    	for (int i = start; i <= n; i++) {
    		if (n - start + 1 < k) break;
    		list.add(i);
    		k--;
    		generate(n, i + 1, k, list, res);
    		k++;
    		list.remove(list.size() - 1);
    	}
    }
}
