package algorithms.dp;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
	 * containing all 1's and return its area.
	 * 
	 * Example For example, given the following matrix:
	 * 
	 * 1 0 1 0 0 
	 * 1 0 1 1 1 
	 * 1 1 1 1 1 
	 * 1 0 0 1 0
	 * 
	 * Return 4.
	 */
	/*
	 * f(i, j): set point(i, j) as the right bottom corner,
	 * calculate the maximum square
	 */
	public static int maxSquare(int[][] M) {
		if (M == null || M.length == 0) return 0;
        
        int m = M.length;
        int n = M[0].length;
        
        int[][] f = new int[m][n];

        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = M[i][j];
                    area = Math.max(area, f[i][j] * f[i][j]);
                    continue;
                }
                if (M[i][j] == 1) {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                    area = Math.max(area, f[i][j] * f[i][j]);
                }
            }
        }
        
        return area;
	}
}
