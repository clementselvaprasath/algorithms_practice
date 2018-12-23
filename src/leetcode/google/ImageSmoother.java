package leetcode.google;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * Example 1:
 * 
 * Input:
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

 * 
 * @author qz
 *
 */
public class ImageSmoother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) return M;
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getAvg(M, i, j);
            }
        }

        return res;
    }

    private int getAvg(int[][] M, int r, int c) {
        int[] idx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] idy = {-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 1, sum = M[r][c];
        for (int i = 0; i < idx.length; i++) {
            int x = r + idx[i];
            int y = c + idy[i];
            if (x < 0 || y < 0 || x >= M.length || y >= M[0].length) continue;
            count++;
            sum += M[x][y];
        }

        return sum / count;
    }
}
