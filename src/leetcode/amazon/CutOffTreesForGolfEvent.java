package leetcode.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.
 */
public class CutOffTreesForGolfEvent {

	class Solution {
		int[] idx = {-1, 0, 1, 0};
		int[] idy = {0, 1, 0, -1};
	    public int cutOffTree(List<List<Integer>> forest) {
	        if (forest == null || forest.isEmpty() || forest.get(0).isEmpty()) return 0;
	        int m = forest.size(), n = forest.get(0).size();
	        int[][] grid = new int[m][n];
	        List<Point> points = new ArrayList<>();
	        for (int i = 0; i < forest.size(); i++) {
	        	for (int j = 0; j < forest.get(i).size(); j++) {
	        		grid[i][j] = forest.get(i).get(j);
	        		if (grid[i][j] > 1) points.add(new Point(i, j, grid[i][j]));
	        	}
	        }

	        Collections.sort(points, (a, b) -> a.val - b.val);

	        Point start = new Point(0, 0, grid[0][0]);
	        int sum = 0;
	        for (Point point : points) {
	        	int steps = findShortestPath(start, point, grid);
	        	if (steps == -1) return -1;
	        	sum += steps;
	        	start = point;
	        }

	        return sum;
	    }

	    private int findShortestPath(Point start, Point point, int[][] grid) {
	    	if (start.x == point.x && start.y == point.y) return 0;
	    	Deque<Point> queue = new ArrayDeque<>();
	    	queue.add(start);
	    	boolean[][] visited = new boolean[grid.length][grid[0].length];
	    	visited[start.x][start.y] = true;
	    	int steps = 0;
	    	while (!queue.isEmpty()) {
	    		int size = queue.size();
	    		for (int i = 0; i < size; i++) {
	    			Point p = queue.poll();
	    			if (p.x == point.x && p.y == point.y) return steps;
	    			for (int j = 0; j < 4; j++) {
	    				int nx = p.x + idx[j];
	    				int ny = p.y + idy[j];
	    				if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == 0 || visited[nx][ny]) {
	    					continue;
	    				}
	    				queue.offer(new Point(nx, ny, grid[nx][ny]));
	    				visited[p.x][p.y] = true;
	    			}
	    		}
	    		steps++;
	    	}

	    	// no path
	    	return -1;
	    }

	    private class Point {
	    	int x;
	    	int y;
	    	int val;
	    	public Point(int x, int y, int val) {
	    		this.x = x;
	    		this.y = y;
	    		this.val = val;
	    	}
	    }
	}
}
