package algorithms.dfs_bfs;

/**
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 * 
 * @author qz
 *
 */
public class NQueens_II {
	
	int sum = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] used = new int[n];
        search(used, 0);
        return sum;
    }

    private void search(int[] used, int row) {
    	if (row == used.length) {
    		sum++;
    		return;
    	}

    	for (int i = 0; i < used.length; i++) {
    		if (isValid(used, i, row)) {
    			used[row] = i;
    			search(used, row + 1);
    		}
    	}
    }

    private boolean isValid(int[] used, int c, int row) {
    	for (int i = 0; i < row; i++) {
    		if (used[i] == c) return false;
    		if (used[i] - i == c - row || used[i] + i == c + row) return false;
    	}
    	return true;
    }
}
