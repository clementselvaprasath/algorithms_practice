package leetcode.google;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * Example: Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output:
 * [1,2,4,7,5,3,6,8,9]
 * 
 * Note: The total number of elements of the given matrix will not exceed
 * 10,000.
 * 
 * @author qz
 *
 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, k = 0;
        boolean moveUp = true;
        for (k = 0; k < res.length; k++) {
            res[k] = matrix[i][j];
            if (moveUp) {
                if (i > 0 && j < n - 1) {
                    i--;
                    j++;
                } else {
                    if (j + 1 >= n) {
                        i++;
                    } else {
                        j++;
                    }
                    moveUp = false;
                }
            } else {
                if (i < m - 1 && j > 0) {
                    i++;
                    j--;
                } else {
                    if (i + 1 >= m) {
                        j++;
                    } else {
                        i++;
                    }
                    moveUp = true;
                }
            }
        }
        
        return res;
    }
	
	public int[] findDiagonalOrder_concise(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, d = 1;
        for (int k = 0; k < res.length; k++) {
            res[k] = matrix[i][j];
            i -= d;
            j += d;
            if (i >= m) {
                i = m - 1;
                j += 2;
                d = -d;
            }
            if (j >= n) {
                j = n - 1;
                i += 2;
                d = -d;
            }
            if (i < 0) {
                i = 0;
                d = -d;
            }
            if (j < 0) {
                j = 0;
                d = -d;
            }
        }
        
        return res;
    }
	
}
