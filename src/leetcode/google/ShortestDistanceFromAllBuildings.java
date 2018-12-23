package leetcode.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the
 * shortest amount of distance. You can only move up, down, left and right. You
 * are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely. Each 1 marks a
 * building which you cannot pass through. Each 2 marks an obstacle which you
 * cannot pass through. For example, given three buildings at (0,0), (0,4),
 * (2,2), and an obstacle at (0,2):
 * 
 *  1 - 0 - 2 - 0 - 1
	|   |   |   |   |
	0 - 0 - 0 - 0 - 0
	|   |   |   |   |
	0 - 0 - 1 - 0 - 0
 * 
 * The point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note: There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 * 
 * @author qz
 *
 */
public class ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] idx = {-1, 0, 1, 0};
    int[] idy = {0, 1, 0, -1};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];

        int flag = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // do BFS
                    bfs(grid, dist, new Point(i, j), flag);
                    flag--;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == flag && dist[i][j] < min) {
                    min = dist[i][j];
                }
            }
        }

        return min == Integer.MAX_VALUE? -1 : min;
    }

    private void bfs(int[][] grid, int[][] dist, Point start, int flag) {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(start);
        int counter = 0;
        while (!q.isEmpty()) {
            List<Point> list = new ArrayList<>();
            counter++;
            while(!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int r = p.x + idx[i];
                    int c = p.y + idy[i];
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == flag - 1 || grid[r][c] != flag) continue;
                    grid[r][c] = flag - 1;
                    dist[r][c] += counter;
                    list.add(new Point(r, c));
                }
            }
            q.addAll(list);
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
}
