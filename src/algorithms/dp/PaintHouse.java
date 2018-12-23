package algorithms.dp;

public class PaintHouse {

	public static void main(String[] args) {
		int[][] costs = { { 1, 5, 6 }, { 14, 15, 5 }, { 4, 3, 3 }, { 15, 15, 9 }, { 9, 2, 7 }, { 6, 5, 7 },
				{ 19, 4, 4 }, { 6, 13, 3 }, { 8, 16, 20 }, { 18, 7, 9 } };
		System.out.println(paintHouse(costs));
	}

	/*
	 * There are a row of n houses, each house can be painted with one of the k
	 * colors. The cost of painting each house with a certain color is different.
	 * You have to paint all the houses such that no two adjacent houses have the
	 * same color.
	 * 
	 * The cost of painting each house with a certain color is represented by a n x
	 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
	 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
	 * on... Find the minimum cost to paint all houses.
	 * 
	 * Example Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
	 * 
	 * house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10
	 * 
	 * Challenge Could you solve it in O(nk)?
	 */
	public static int paintHouse(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;
		int m = costs.length, n = costs[0].length;

		int[][] f = new int[m + 1][n];
		int min1 = 0, min2 = 0; // min1: smallest value, min2: second smallest value
		int j1 = 0, j2 = 0; // j1: smallest index, j2: second smallest index
		for (int i = 1; i <= m; i++) {
			min1 = min2 = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (f[i - 1][j] < min1) {
					min2 = min1;
					min1 = f[i - 1][j];
					j2 = j1;
					j1 = j;
				} else {
					if (f[i - 1][j] < min2) {
						min2 = f[i - 1][j];
						j2 = j;
					}
				}
			}
			for (int j = 0; j < n; j++) {
				if (j == j1) {
					f[i][j] = min2 + costs[i - 1][j];
				} else {
					f[i][j] = min1 + costs[i - 1][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i : f[m]) {
			if (i < min)
				min = i;
		}
		return min;
	}

	// O(1) space
	public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        
        int min = 0, min_index = 0, min2 = 0;
        for (int i = 0; i < m; i++) {
            int current_min = Integer.MAX_VALUE, current_min_index = Integer.MAX_VALUE, current_min2 = 0;
            for (int j = 0; j < n; j++) {
                int c = costs[i][j];
                if (min_index == j) {
                    c += min2;
                } else {
                    c += min;
                }
                if (c <= current_min) {
                    current_min2 = current_min;
                    current_min = c;
                    current_min_index = j;
                } else if (c < current_min2) {
                    current_min2 = c;
                }
            }
            min = current_min;
            min2 = current_min2;
            min_index = current_min_index;
        }
       
        return min;
    }

	private static int getMin(int[] a, int skip) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (i != skip && min > a[i]) {
				min = a[i];
			}
		}

		return min;
	}
}
