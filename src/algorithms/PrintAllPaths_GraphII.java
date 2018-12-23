package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths_GraphII {
	public static void main(String[] args) {
		int[][] graph = { 
				{ 0, 1, 0, 0, 1 }, 
				{ 0, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 } 
			};
		int start = 0;
		int end = 4;
		printAllPaths(graph, start, end);
	}

	public static void printAllPaths(int[][] m, int start, int end) {
		boolean[] visited = new boolean[m.length];
		List<List<String>> result = getAllPath(m, start, end, visited);
		for (List<String> list : result) {
			for (int i = list.size() - 1; i >= 0; i--) {
				System.out.print(list.get(i));
				if (i > 0) {
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}
	}

	public static void resetVisited(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	public static List<List<String>> getAllPath(int[][] m, int start, int end, boolean[] visited) {
		List<List<String>> result = new ArrayList<>();
		String val = "" + start;
		// find the end
		if (start == end) {
			List<String> r = new ArrayList<>();
			r.add(val);
			result.add(r);
			return result;
		}

		// find neighbors and recursively process it
		for (int i = 0; i < m[start].length; i++) {
			// exist reachable neighbor
			if (m[start][i] == 1 && visited[i] == false) {
				visited[start] = true;
				List<List<String>> paths = getAllPath(m, i, end, visited);
				if (paths != null) {
					for (List<String> list : paths) {
						list.add(val);
					}
					result.addAll(paths);
				}
				visited[i] = false;
			}
		}

		return result.isEmpty() ? null : result;
	}

}
