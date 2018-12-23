package leetcode.google;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * 	Example 1:
     0          3
     |          |
     1 --- 2    4
	Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
	
	Example 2:
	     0           4
	     |           |
	     1 --- 2 --- 3
	Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author qz
 *
 */
public class FindConnectedComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}

		return uf.getCount();
	}

	class UnionFind {
		int[] root;
		int count;

		public UnionFind(int size) {
			root = new int[size];
			for (int i = 0; i < size; i++) {
				root[i] = i;
			}
			count = size;
		}

		public void union(int a, int b) {
			int root_a = findRoot(a);
			int root_b = findRoot(b);
			if (root_a != root_b) {
				root[root_a] = root_b;
				count--;
			}
		}

		public int findRoot(int a) {
			if (root[a] == a) {
				return a;
			}
			return root[a] = findRoot(root[a]);
		}

		public int getCount() {
			return count;
		}
	}
}
