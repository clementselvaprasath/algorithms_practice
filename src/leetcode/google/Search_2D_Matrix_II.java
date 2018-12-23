package leetcode.google;

public class Search_2D_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix, return the occurrence of it.
	 * 
	 * This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. Integers in each
	 * column are sorted from up to bottom. No duplicate integers in each row or
	 * column.
	 * 
	 * Example
		Consider the following matrix:
		
		[
		  [1, 3, 5, 7],
		  [2, 4, 7, 8],
		  [3, 5, 9, 10]
		]
		Given target = 3, return 2.
	 *
	 * O(m+n) time and O(1) extra space
	 */

	//move from bottom left to top right
	public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;
	    
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    int r = m - 1, c = 0;
	    int res = 0;
	    
	    while (r >= 0 && c < n) {
	    	if (matrix[r][c] == target) {
	    		res++;
	    		r--;
	    		c++;
	    	} else if (matrix[r][c] > target) {
	    		r--;
	    	} else {
	    		c++;
	    	}
	    }

	    return res;
    }
}
