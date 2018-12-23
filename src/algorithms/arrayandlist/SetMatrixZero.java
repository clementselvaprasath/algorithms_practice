package algorithms.arrayandlist;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * @author qz
 *
 */
public class SetMatrixZero {

	public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;

        boolean zeroRow = false;
        boolean zeroCol = false;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroRow = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                zeroCol = true;
                break;
            }
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }

        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if (zeroRow) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (zeroCol) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
