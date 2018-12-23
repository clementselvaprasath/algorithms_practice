package leetcode.amazon;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother to make the gray scale of each cell 
 * becomes the average gray scale (rounding down) of all the 8 
 * surrounding cells and itself. If a cell has less than 8 surrounding 
 * cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 * @author qz
 *
 */
public class ImageSmoother {

	public int[][] imageSmoother(int[][] M) {
        int[] idx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] idy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int r = M.length, c = M[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int sum = M[i][j], count = 1;
                for (int k = 0; k < 8; k++) {
                    int x = i + idx[k];
                    int y = j + idy[k];
                    if (x >= 0 && x < r && y >=0 && y < c) {
                        sum += M[x][y];
                        count++;
                    }
                }
                res[i][j] = Math.floorDiv(sum, count);
            }
        }
        
        return res;
    }
}
