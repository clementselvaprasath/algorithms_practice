package algorithms.dp;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
	 */
	
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = grid[0][i] + f[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }

        return f[m - 1][n - 1];
    }
}
