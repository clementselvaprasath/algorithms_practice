package leetcode.apple;

/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 * @author qz
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// get a transpose of matrix m, and swap elements symmetric
	public void rotate_better(int[][] m) {
        int n = m.length;
    
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = m[i][j];
                m[i][j] = m[i][n - j - 1];
                m[i][n - j - 1] = tmp;
            }
        }
    }
	
	// be care of the start and end of the i, j
	public void rotate(int[][] m) {
        int n = m.length;
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = m[i][j];
                //bot left -> top left
                m[i][j] = m[n - j - 1][i];
                // bot right -> bot left
                m[n - j - 1][i] = m[n - i - 1][n - j - 1];
                // top right -> bot right
                m[n - i - 1][n - j - 1] = m[j][n - i - 1];
                // top left -> top right
                m[j][n - i - 1] = tmp;
            }
        }
    }
}
