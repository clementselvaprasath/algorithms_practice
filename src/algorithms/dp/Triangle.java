package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

	 */
	public int minimumTotal(List<List<Integer>> T) {
        if (T.isEmpty()) return 0;
        int n = T.size();

        List<Integer> list = null;
        List<Integer> preList = null;
        for (int i = n - 1; i >= 0; i--) {
            list = new ArrayList<Integer>(T.get(i));
            if (i == n - 1) continue;
            if (preList == null) preList = new ArrayList<Integer>(T.get(i + 1));
            for (int j = 0; j < list.size(); j++) {
                list.set(j, Math.min(preList.get(j) , preList.get(j + 1)) + T.get(i).get(j));
            }
            preList = list;
        }

        int res = Integer.MAX_VALUE;
        for (int i : list) {
            res = Math.min(res, i);
        }
        return res;
    }
}
