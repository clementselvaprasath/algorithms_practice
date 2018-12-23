package leetcode.apple;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find
 * and return the longest length of set S, where S[i] = {A[i], A[A[i]],
 * A[A[A[i]]], ... } subjected to the rule below.
 * 
 * Suppose the first element in S starts with the selection of element A[i] of
 * index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By
 * that analogy, we stop adding right before a duplicate element occurs in S.
 * 
 * Example 1: Input: A = [5,4,0,3,1,6,2] Output: 6 Explanation: A[0] = 5, A[1] =
 * 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 
 * One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0} Note:
 * N is an integer within the range [1, 20,000]. The elements of A are all
 * distinct. Each element of A is an integer within the range [0, N-1].
 * 
 * @author qz
 *
 */
public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int next = i, counter = 1;
            while (i != nums[next]) {
                visited[next] = true;
                counter++;
                next = nums[next];
            }
            res = Math.max(res, counter);
        }
        
        return res;
    }
	
	public int arrayNesting_unionfind(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.union(i, nums[i]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, uf.count[i]);
        }
        
        return res;
    }
	class UnionFind {
	    int[] parent;
	    int[] count;
	    public UnionFind(int n) {
	        parent = new int[n];
	        count = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	            count[i] = 1;
	        }
	    }
	    
	    public void union(int a, int b) {
	        int root_a = find(a);
	        int root_b = find(b);
	        if (root_a == root_b) return;
	        if (count[root_a] >= count[root_b]) {
	            parent[root_b] = root_a;
	            count[root_a] += count[root_b];
	            count[root_b] = 0;
	        } else {
	            parent[root_a] = root_b;
	            count[root_b] += count[root_a];
	            count[root_a] = 0;
	        }
	    }
	    
	    public int find(int a) {
	        if (parent[a] == a) return a;
	        return parent[a] = find(parent[a]);
	    }
	}
}
