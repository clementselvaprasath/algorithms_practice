package algorithms.dp;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a 2D boolean matrix filled with False and True, find the largest
	 * rectangle containing all True and return its area.
	 * 
	 * Example Given a matrix:
	 * 
	 * [ 
	 * [1, 1, 0, 0, 1], 
	 * [0, 1, 0, 0, 1], 
	 * [0, 0, 1, 1, 1], 
	 * [0, 0, 1, 1, 1], 
	 * [0, 0, 0, 0, 1] 
	 * ] 
	 * 
	 * return 6.
	 * 
	 * [[0,1,1],[1,1,1],[1,1,1],[1,1,1],[0,1,1]]
	 * 
	 * return 10;
	 * 
	 */
	public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m][n];        
        for (int j = 0; j < n; j++) {
        	f[0][j] = matrix[0][j] == '1'? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '1') {
        			f[i][j] = f[i - 1][j] + 1;
        		}
        	}
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (f[i][j] > 0) {
        			int min = f[i][j];
        			for (int k = j; k >= 0 && f[i][k] > 0; k--) {
        				min = Math.min(min, f[i][k]);
        				max = Math.max(max, min * (j - k + 1));
        			}
        		}
        	}
        }

        return max;
    }
	
	public int maximalRectangle_monolithic_stack(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n];        
        int max = 0;

        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
                if (i == 0) {
                    f[j] = matrix[i][j] == '1'? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        f[j] = f[j] + 1;
                    } else {
                        f[j] = 0;
                    }
                }
        	}

        	max = Math.max(max, maxAreaInHist(f));
        }

        return max;
    }

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();

	    int i = 0, max = 0;
	    while (i < height.length) {
	        if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
	            stack.push(i++);
	        } else {
	            int t = stack.pop();
	            max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	        }
	    }
	    while (!stack.isEmpty()) {
	    	int t = stack.pop();
	        max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	    }

	    return max;
    }
	
	public int maximalRectangle_optimalspace(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n];        
        int max = 0;
        for (int j = 0; j < n; j++) {
        	f[j] = matrix[0][j] == '1'? 1 : 0;

        }

        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (matrix[i][j] == '1') {
                        f[j] = f[j] + 1;
                    } else {
                        f[j] = 0;
                    }
                }

        		if (f[j] > 0) {
        			int min = f[j];
        			for (int k = j; k >= 0 && f[k] > 0; k--) {
        				min = Math.min(min, f[k]);
        				max = Math.max(max, min * (j - k + 1));
        			}
        		}
        	}
        }

        return max;
    }
}
