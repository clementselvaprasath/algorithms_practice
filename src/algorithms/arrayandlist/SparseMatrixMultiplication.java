package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

 * @author qz
 *
 */
public class SparseMatrixMultiplication {

	public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B.length, t = B[0].length;
        
        int[][] res = new int[m][t];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (A[i][j] == 0) continue;
        		for (int k = 0; k < t; k++) {
        			res[i][k] += A[i][j] * B[j][k];
        		}
        	}
        }

        return res;
    }
	
	// 改进做法
	public int[][] multiply_optimal(int[][] A, int[][] B) {
        // Write your code here
		int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        int[][] C = new int[n][m];

        List<List<Integer>> col = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            col.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (B[i][j] != 0) {
                    col.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int p = 0; p < col.get(k).size(); p++) {
                    int j = col.get(k).get(p);
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
