package algorithms.dp;

public class MatrixMultiplication {
	// 30 35 35 15 15 5 5 10 10 20 20 25
	public static void main(String[] args) {
		int[] p = new int[] { 30, 35, 15, 5, 10, 20, 25 };
		int[][] m = new int[p.length][p.length];
		
		//System.out.println(getMatrixMultiplication_TopDown(p, 1, p.length-1, m));
		System.out.println(getMatrixMultiplication(p));
		//printMatrix(m);
	}

	private static int getMatrixMultiplication(int[] p) {
		int n = p.length - 1;
		char[] matrix = new char[p.length];
		for (int i = 1; i < p.length; i++) {
			matrix[i] = (char) ('A' + i - 1);
		}
		
		int[][] m = new int[p.length][p.length];
		int[][] s = new int[p.length][p.length];
		for(int l = 2; l <= n; l++) {
			for(int i = 1; i <= n-l+1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		
		printMatrix(matrix, s, 1, n);
		System.out.println();
		return m[1][n];
	}
	
	private static void printMatrix(char[] m, int[][] s, int i, int j) {
		if (i == j) {
			System.out.print(m[i]);
		} else {
			System.out.print("(");
			printMatrix(m, s, i, s[i][j]);
			printMatrix(m, s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
	
	private static int getMatrixMultiplication_TopDown(int[] p, int start, int end, int[][] m) {
		if(m[start][end] > 0) return m[start][end];
		if(start == end) return 0;
		
		m[start][end] = Integer.MAX_VALUE;
		for(int k=start; k<end; k++) {
			int q = getMatrixMultiplication_TopDown(p, start, k, m)
					+ getMatrixMultiplication_TopDown(p, k+1, end, m)
					+ p[start-1] * p[k] * p[end];
			if(q < m[start][end]) {
				m[start][end] = q;
			}
		}
		
		return m[start][end];
	}
	
	private static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
