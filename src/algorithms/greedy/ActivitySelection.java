package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

	public static void main(String[] args) {
		int[] s = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] f = { 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
		System.out.println(findMaxActivity_DP(s, f));
		System.out.println(findMaxActivity_Greedy(s, f));
	}

	public static int findMaxActivity_DP(int[] s, int[] e) {
		if (s.length != e.length) return 0;
		int n = s.length;
		// f(i,j) means numbers of activities can be schedule
		// between a[i] and a[j]
		int[][] f = new int[n][n];
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++ ) {
			f[i][i] = 1;
		}
		
		for (int l = 3; l <= n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				f[i][j] = Integer.MIN_VALUE;
				int max = -1;
				for (int k = i + 1; k < j; k++) {
					int total = 1;
					// find left
					for (int p = k - 1; p >= i; p--) {
						if (s[k] >= e[p]) {
							total += f[i][p];
							break;
						}
					}
					// find right
					for (int p = k + 1; p <= j; p++) {
						if (e[k] <= s[p]) {
							total += f[p][j];
							break;
						}
					}
					//f[i][j] = Math.max(f[i][j], total);
					if (f[i][j] < total) {
						f[i][j] = total;
						max = k;
					}
				}
				a[i][j] = max;
			}
		}
		
		printMatrix(f);
		
		System.out.println();
		System.out.println();
		
		printMatrix(a);
		int res = 0, left = 0, right = 0;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (res < f[i][j]) {
					res = f[i][j];
					left = i;
					right = j;
				}
			}
		}
		
		return res;
	}

	public static int findMaxActivity_Greedy(int[] s, int[] e) {
		if (s.length != e.length) return 0;
		int n = s.length;
		List<Integer> list = new ArrayList<Integer>();
		int i = 1, end = e[0];
		list.add(0);
		while (i < n) {
			if (s[i] >= end) {
				end = e[i];
				list.add(i);
			}
			i++;
		}
		
		for(int index : list) {
			System.out.print(index + " ");
		}
		System.out.println();
		return list.size();
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
