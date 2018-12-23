package leetcode.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author qz
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate_i(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if (numRows == 0)
			return res;
		List<Integer> init = Arrays.asList(1);
		res.add(init);
		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = res.get(res.size() - 1);
			List<Integer> nlist = new ArrayList<>();
			nlist.add(1);
			for (int j = 1; j < prev.size(); j++) {
				nlist.add(prev.get(j - 1) + prev.get(j));
			}
			nlist.add(1);
			res.add(nlist);
		}
		return res;
	}

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> prev = Arrays.asList(1);
		if (rowIndex == 0)
			return prev;
		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> nlist = new ArrayList<>();
			nlist.add(1);
			for (int j = 1; j < prev.size(); j++) {
				nlist.add(prev.get(j - 1) + prev.get(j));
			}
			nlist.add(1);
			prev = nlist;
		}

		return prev;
	}
}
