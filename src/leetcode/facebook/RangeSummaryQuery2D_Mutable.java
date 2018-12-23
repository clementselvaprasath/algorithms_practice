package leetcode.facebook;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author qz
 *
 */
public class RangeSummaryQuery2D_Mutable {

	class NumMatrix {
	    int[][] A, C;
	    int m;
	    int n;
	    
	    public NumMatrix(int[][] matrix) {
	        if (matrix.length == 0) return;
	        m = matrix.length;
	        n = matrix[0].length;
	        C = new int[m + 1][n + 1];
	        A = new int[m][n];
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                update(i, j, matrix[i][j]);
	            }
	        }
	    }
	    
	    public void update(int row, int col, int val) {
	        updateTree(row, col, val - A[row][col]);
	        A[row][col] = val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
	    }
	    
	    private void updateTree(int row, int col, int val) {
	        row++;
	        col++;
	        for (int i = row; i <= m; i += lowbit(i)) {
	            for (int j = col; j <= n; j += lowbit(j)) {
	                C[i][j] += val; 
	            }
	        }
	    }
	    
	    private int getSum(int row, int col) {
	        row++;
	        col++;
	        int res = 0;
	        for (int i = row; i >= 1; i -= lowbit(i)) {
	            for (int j = col; j >= 1; j -= lowbit(j)) {
	                res += C[i][j];
	            }
	        }
	        
	        return res;
	    }
	    
	    private int lowbit(int x) {
	        return x & -x;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * obj.update(row,col,val);
	 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
	 */
}
