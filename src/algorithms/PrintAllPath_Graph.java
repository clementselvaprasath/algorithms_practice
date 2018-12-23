package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath_Graph {
	
	public static void main(String[] args) {
		int[][] graph = { 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 } 
			};
		int start = 0;
		int end = 4;
		printAllPaths(graph, start, end);
	}
	
	public static void printAllPaths (int[][] m, int start, int end) {
		boolean[][] v = new boolean[m.length][m[0].length];
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				v[i][j] = false;
			}
		}
		List<List<String>> result = getAllPath (m, v, start, end);
		for (List<String> list : result) {
			for (int i = list.size() - 1; i >= 0 ; i--) {
				System.out.print(list.get(i));
				if (i > 0) {
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> getAllPath (int[][]m, boolean[][] v, int start, int end) {
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
			// visited
			if (v[start][i]) {
				continue;
			}
			// exist reachable neighbor
			if (m[start][i] == 1) {
				v[start][i] = true;
				List<List<String>> paths = getAllPath (m, v, i, end);
				if (paths != null) {
					for (List<String> list : paths) {
						list.add(val);
					}
					result.addAll(paths);
				}
			}
		}
		
		return result.isEmpty() ? null : result;
	}
}
