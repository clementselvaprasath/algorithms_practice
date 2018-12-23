package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * 
 * @author qz
 *
 */
public class NQueens {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		search(new ArrayList<Integer>(), n, res);
		return res;
	}

	private void search(List<Integer> rows, int n, List<List<String>> res) {
		if (rows.size() == n) {
			res.add(drawBoard(rows));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(rows, col)) {
				continue;
			}
			rows.add(col);
			search(rows, n, res);
			rows.remove(rows.size() - 1);
		}
	}

	private boolean isValid(List<Integer> rows, int col) {
		for (int i = 0; i < rows.size(); i++) {
			int c = rows.get(i);
			if (c == col)
				return false;
			if (c - i == col - rows.size() || i + c == rows.size() + col)
				return false;
		}

		return true;
	}

	private List<String> drawBoard(List<Integer> rows) {
		int n = rows.size();
		List<String> board = new ArrayList<>();
		for (int c : rows) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (c == i) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			board.add(sb.toString());
		}

		return board;
	}
}
