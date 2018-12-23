package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In this problem, a rooted tree is a directed graph such that, there is
 * exactly one node (the root) for which all other nodes are descendants of this
 * node, plus every node has exactly one parent, except for the root node which
 * has no parents.
 * 
 * The given input is a directed graph that started as a rooted tree with N
 * nodes (with distinct values 1, 2, ..., N), with one additional directed edge
 * added. The added edge has two different vertices chosen from 1 to N, and was
 * not an edge that already existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is
 * a pair [u, v] that represents a directed edge connecting nodes u and v, where
 * u is a parent of child v.
 * 
 * Return an edge that can be removed so that the resulting graph is a rooted
 * tree of N nodes. If there are multiple answers, return the answer that occurs
 * last in the given 2D-array.
 * 
 * Example 1:
	Input: [[1,2], [1,3], [2,3]]
	Output: [2,3]
	Explanation: The given directed graph will be like this:
	  1
	 / \
	v   v
	2-->3
	Example 2:
	Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
	Output: [4,1]
	Explanation: The given directed graph will be like this:
	5 <- 1 -> 2
	     ^    |
	     |    v
	     4 <- 3
 * 
 * Note: The size of the input 2D-array will be between 3 and 1000. Every
 * integer represented in the 2D-array will be between 1 and N, where N is the
 * size of the input array.
 * 
 * @author qz
 *
 */
public class RedundantConnection_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];
        int n = edges.length;
        
        // find candidates with more than one parent
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> candidates = null;
        int dual_p = 0;
        for (int[] edge : edges) {
            List<Integer> parents = map.getOrDefault(edge[1], new ArrayList<>());
            parents.add(edge[0]);
            map.put(edge[1], parents);
            if (parents.size() > 1) {
                candidates = parents;
                dual_p = edge[1];
            }
        } 

        // detect cycle
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        boolean findDual = false;
        for (int[] edge : edges) {
            int child = edge[1], father = edge[0];
            if (dual_p == child) {
                if (findDual) continue;
                else findDual = true;
            }
            if (find(parent, father) == child) {
                if (candidates != null) {
                    return new int[]{candidates.get(0), dual_p};
                } else {
                    return edge;
                }
            } else {
                parent[child] = father;
            }
        }
        if (candidates != null) {
            return new int[]{candidates.get(1), dual_p};
        }

        return new int[0];
    }

    private int find(int[] parent, int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent, parent[a]);
    }
}
