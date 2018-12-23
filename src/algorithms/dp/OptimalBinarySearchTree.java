package algorithms.dp;

public class OptimalBinarySearchTree {
	
	public static void main(String[] args) {
		// keys' frequencies
		double[] p = new double[] {0, 0.15, 0.10, 0.05, 0.10, 0.20};
		// dummies' frequencies
		double[] q = new double[] {0.05, 0.10, 0.05, 0.05, 0.05, 0.10};
		
		System.out.println(findOptimalBinarySearchTree(p, q));
	}
	
	private static double findOptimalBinarySearchTree(double[] p, double[] q) {
		if (p == null || q == null) return 0;
		int pn = p.length, qn = q.length;
		if (pn == 0 || qn == 0) return 0;
		
		double[][] f = new double[pn+1][pn];
		double[][] sum = new double[pn+1][pn];
		for (int i = 1; i < pn+1; i++) {
			f[i][i-1] = q[i-1];
			sum[i][i-1] = q[i-1];
		}
		
		for (int l = 1; l <= pn+1; l++) {
			for (int i = 1; i < pn - l + 1; i++) {
				int j = i + l - 1;
				f[i][j] = Integer.MAX_VALUE;
				sum[i][j] = sum[i][j-1] + p[j] + q[j];
				for (int k = i; k <= j; k++) {
					double r = f[i][k-1] + f[k+1][j] + sum[i][j];
					if (r < f[i][j]) f[i][j] = r;
				}
			}
		}
		return f[1][pn-1];
	}
	
	private static void printMatrix (double[][] m) { 
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
