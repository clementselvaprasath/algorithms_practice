package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author qz
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		
		int[][] m = new int[][]{
				{2, 3}
		};
		List<Integer> list = spiralOrder(m);
		for (Integer i : list) {
			System.out.print(i + "\t");
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right || top <= bottom) {
            // top left -> top right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            // top right -> bottom right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            // bottom right -> bottom left
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;
            // bottom left -> top left
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (right < left) break;
        }
        
        return res;
    }
}
