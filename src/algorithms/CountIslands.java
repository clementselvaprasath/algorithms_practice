package algorithms;

public class CountIslands {

	public static void main(String[] args) {
		int[][] m = new int[][]{
			{0, 0, 1, 1, 0},
			{0, 1, 1, 0, 0},
			{1, 0, 0, 0, 0},
			{0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1}
		};
		
		System.out.println(countIslands(m));
	}

	// count the total number of the islands
	public static int countIslands (int[][] m) {
		if (m.length < 1) return 0;
		int r = m.length;
		int c = m[0].length;
		
		int total = 0;
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (m[i][j] == 1) {	// find an island
					total++;
					zeroOut (m, visited, i, j);	// zero out
				}
			}
		}
		
		return total;
	}
	
	public static void zeroOut (int[][] m, boolean[][] visited, int r, int c) {
		if (m[r][c] == 0 || visited[r][c]) return;
		
		visited[r][c] = true;
		m[r][c] = 0;
		if (r - 1 >= 0) zeroOut(m, visited, r-1, c);
		if (r + 1 < m.length) zeroOut(m, visited, r+1, c);
		if (c - 1 >= 0) zeroOut(m, visited, r, c-1);
		if (c + 1 < m[0].length) zeroOut(m, visited, r, c+1);
	}
}
