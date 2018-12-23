package algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

	public static void main(String[] args) {
		int[][] g = {
				{0,1,1,0,0},
				{1,0,1,0,1},
				{1,1,0,1,0},
				{0,0,1,0,1},
				{0,1,0,1,0},
		};
		System.out.println(bfs(g, 0, 4));
	}

	// find shortest path
	public static int bfs (int[][] G, int S, int T) {
		if (G == null || G.length == 0) return Integer.MAX_VALUE;
		
		int m = G.length;
		boolean[] visited = new boolean[m];
		
		Queue<Vertex> q = new LinkedList<>();
		q.add(new Vertex(S, 0));
		while (!q.isEmpty()) {
			Vertex v = q.poll();
			if (v.p == T) return v.dist;
			int[] adj = G[v.p];
			
			for (int i = 0; i < adj.length; i++) {
				if (adj[i] != 0 && !visited[i]) {
					q.offer(new Vertex(i, v.dist + 1));
				}
			}
			visited[v.p] = true;
		}
		
		return 0;
	}
}
class Vertex {
	int p;
	int dist;
	public Vertex (int p, int dist) {
		this.p = p;
		this.dist = dist;
	}
}