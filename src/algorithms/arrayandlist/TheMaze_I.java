package algorithms.arrayandlist;

/**
 * 490. The Maze
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, determine
 * whether the ball could stop at the destination.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * Note: There is only one ball and one destination in the maze. Both the ball
 * and the destination exist on an empty space, and they will not be at the same
 * position initially. The given maze does not contain border (like the red
 * rectangle in the example pictures), but you could assume the border of the
 * maze are all walls. The maze contains at least 2 empty spaces, and both the
 * width and height of the maze won't exceed 100.
 * 
 * 
 * @author qz
 *
 */
public class TheMaze_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze.length == 0)
			return false;
		int m = maze.length, n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		return hasPath(maze, start, destination, visited);
	}

	private boolean hasPath(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;
		visited[start[0]][start[1]] = true;
		// top
		for (int i = start[0]; i >= 0; i--) {
			if (i == 0 || maze[i - 1][start[1]] == 1) {
				if (!visited[i][start[1]]) {
					boolean found = hasPath(maze, new int[] { i, start[1] }, destination, visited);
					if (found)
						return true;
				}
				break;
			}
		}
		// down
		for (int i = start[0]; i < maze.length; i++) {
			if (i == maze.length - 1 || maze[i + 1][start[1]] == 1) {
				if (!visited[i][start[1]]) {
					boolean found = hasPath(maze, new int[] { i, start[1] }, destination, visited);
					if (found)
						return true;
				}
				break;
			}
		}
		// right
		for (int i = start[1]; i < maze[0].length; i++) {
			if (i == maze[0].length - 1 || maze[start[0]][i + 1] == 1) {
				if (!visited[start[0]][i]) {
					boolean found = hasPath(maze, new int[] { start[0], i }, destination, visited);
					if (found)
						return true;
				}
				break;
			}
		}
		// left
		for (int i = start[1]; i >= 0; i--) {
			if (i == 0 || maze[start[0]][i - 1] == 1) {
				if (!visited[start[0]][i]) {
					boolean found = hasPath(maze, new int[] { start[0], i }, destination, visited);
					if (found)
						return true;
				}
				break;
			}
		}
		return false;
	}
}
