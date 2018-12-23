package leetcode.google;

public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
	 * (each edge is a pair of nodes), write a function to check whether these
	 * edges make up a valid tree.
	 * 
	 * Notice You can assume that no duplicate edges will appear in edges. Since
	 * all edges are undirected, [0, 1] is the same as [1, 0] and thus will not
	 * appear together in edges.
	 * 
	 * Example 
	 * 
	 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
	 * 
	 */
	public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        if (edges == null || edges.length == 0) return false;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (uf.find(e[0]) == uf.find(e[1])) return false;
            uf.union(e[0], e[1]);
        }
        
        return uf.count == 1;
    }
	class UnionFind {
	    int[] parent;
	    int count;
	    public UnionFind(int n) {
	        parent = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	        }
	        count = n;
	    }
	    
	    public void union(int a, int b) {
	        int root_a = find(a);
	        int root_b = find(b);
	        if (root_a != root_b) {
	            parent[root_a] = root_b;
	            count--;
	        }
	    }
	    
	    public int find(int a) {
	        if (parent[a] == a) {
	            return a;
	        }
	        
	        return parent[a] = find(parent[a]);
	    }
	}
}
