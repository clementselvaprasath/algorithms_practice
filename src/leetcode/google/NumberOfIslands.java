package leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mi = {{1,1,0,0,0},{0,1,0,0,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,0,0,1}};
		boolean[][] grid = new boolean[mi.length][mi[0].length];
		for (int i = 0; i < mi.length; i++) {
			for (int j = 0; j < mi[0].length; j++) {
				grid[i][j] = mi[i][j] == 1;
			}
		}
		System.out.println(numIslands(grid));
	}

	/*
	 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented
	 * as the island. If two 1 is adjacent, we consider them in the same island.
	 * We only consider up/down/left/right adjacent.
	 * 
	 * Find the number of islands.
	 * 
	 * Example Given graph:
	 * [ 
	 * 	[1, 1, 0, 0, 0], 
	 * 	[0, 1, 0, 0, 1], 
	 * 	[0, 0, 0, 1, 1], 
	 * 	[0, 0, 0, 0, 0], 
	 * 	[0, 0, 0, 0, 1] 
	 * ] 
	 * return 3.
	 */
	public int numIslands_dfs(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1' && !visited[i][j]) {
        			ans++;
        			dfs(grid, i, j, visited);
        		}
        	}
        }

        return ans;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
    	if (grid[r][c] == '0' || visited[r][c]) return;

    	visited[r][c] = true;
    	if (r > 0) dfs(grid, r - 1, c, visited);
    	if (r + 1 < grid.length) dfs(grid, r + 1, c, visited);
    	if (c + 1 < grid[0].length) dfs(grid, r, c + 1, visited);
    	if (c > 0) dfs(grid, r, c - 1, visited);
    }
	
	
	public static int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    	int m = grid.length;
    	int n = grid[0].length;
    
    	UnionFind uf = new UnionFind(m * n);
    	int total = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if(grid[i][j]) {
    				total++;
    			}
    		}
    	}
    	uf.setTotal(total);
    
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (grid[i][j]) {
    			    int index = getIndex(i, j, n);
    				if (i > 0 && grid[i - 1][j]) {
    					uf.union (index, index - n);
    				}
    				if (j > 0 && grid[i][j - 1]) {
    					uf.union (index, index - 1);
    				}
    			}
    		}
    	}
    	
    	return uf.query();
    }
    
	private static int getIndex (int r, int c, int m) {
    	return r * m + c;
    }
	
	public static int numIslands_BFS(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    	int m = grid.length;
    	int n = grid[0].length;
    	
    	int count = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (grid[i][j]) {
    				bfs(grid, i, j);
    				count++;
    			}
    		}
    	}
    	
    	return count;
	}
	private static void bfs (boolean[][] grid, int x, int y) {
    	int[] dx = {0, 1, 0, -1};
    	int[] dy = {1, 0, -1, 0};
    	Point p = new Point (x, y);
    	Queue<Point> q = new LinkedList<Point>();
    	q.offer(p);
    	while (!q.isEmpty()) {
    		Point tmp = q.poll();
    		for (int i = 0; i < 4; i++) {
    			Point newP = new Point(tmp.x + dx[i], tmp.y + dy[i]);
    			if (!isValid(newP, grid)) {
    				continue;
    			}
    			if (grid[newP.x][newP.y]) {
    				grid[newP.x][newP.y] = false;
    				q.offer(newP);
    			}
    		}
    	}
    }
    private static boolean isValid(Point p, boolean[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    
    	return p.x >= 0 && p.x < m && p.y >=0 && p.y < n;
    }
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class UnionFind {
	int[] root = null;
	int count;

	public UnionFind (int n) {
		root = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}
	}

	public void setTotal (int t) {
		count = t;
	}

	public int find(int n) {
		if (root[n] == n) {
			return n;
		}
		return root[n] = find(root[n]);
	}

	public void union(int m, int n) {
		int root_m = find(m);
		int root_n = find(n);
		if (root_m != root_n) {
			root[root_m] = root_n;
			count--;
		}
	}

	public int query () {
		return count;
	}
}
