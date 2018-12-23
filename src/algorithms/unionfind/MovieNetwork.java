package algorithms.unionfind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Give some rating of movie (number starting from 0) and their relationship,
 * and relationships can be passed (a and b are related, b and c are related, a
 * and c are also considered to be related). Give every movie's relationship
 * list.Given a movie numbered S, find the top K movies with the highest rating
 * in the movies associated with S(When the number of movies which associated
 * with S is less than K, output all the movies .You can output them in any
 * order). Does not include this movie.
 * 
 * Notice the number of movies is n, and n <= 20000. We guarantee that the
 * number is 0 ~ n-1. We guarantee that the numbers of the 2 vertices of an edge
 * both belong to 0 ~ n-1. We guarantee that the numbers of the edges is m, and
 * m <= 100000. We guarantee that the rating of each movie is not the same.
 * 
 * Example Given ratingArray = {10,20,30,40}, contactRelationship =
 * {{1,3},{0,2},{1},{0}}, S = 0, K = 2, return {2,3}.
 * 
 * Explanation: In contactRelationship, {1,3} is associated with 0,{0,2} is
 * associated with 1,{1} is associated 2,{0} is associated with 3.
 * Finally,Movies numbered {1,2,3} are associated with movie 0, and the order
 * which according to their rating from high to low is {3,2,1}, so the output
 * {2,3}.
 * 
 * Given ratingArray = {10,20,30,40,50,60,70,80,90}, contactRelationship =
 * {{1,4,5},{0,2,3},{1,7},{1,6,7},{0},{0},{3},{2,3},{}}, S = 5, K = 3, return
 * {6,7,4}.
 * 
 * Explanation: In contactRelationship,{1,4,5} is associated with 0,{0,2,3} is
 * associated with 1,{1,7} is associated with 2,{1,6,7} is is associated with
 * 3,{0} is associated with 4,{0} is associated with 5,{3} is associated with
 * 6,{2,3} is associated with 7,no moive is associated with 8. Finally,Movies
 * numbered {0,1,2,3,4,6,7} are associated with movie 5, and the order which
 * according to their rating from high to low is {7,6,4,3,2,1,0}. Notice that
 * movie 8 is not related to movie 5, so it has the highest rating but does not
 * count towards the answer.
 * 
 * @author qz
 *
 */
public class MovieNetwork {

	public static void main(String[] args) {
		
	}

	// union find problem
	public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        if (K == 0 || G.length == 0) return new int[0];
        int n = rating.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < G.length; i++) {
            int[] r = G[i];
            for (int j = 0; j < r.length; j++) {
                uf.union(i, r[j]);
            }
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (!map.containsKey(root)) {
                Set<Integer> set = new TreeSet<>((a, b) -> rating[b] - rating[a]);
                set.add(i);
                map.put(root, set);
            } else {
                map.get(root).add(i);
            }
        }
        
        int root_S = uf.find(S);
        Iterator<Integer> it = map.get(root_S).iterator();
        int size = Math.min(K, map.get(root_S).size() - 1);
        int i = 0;
        int[] res = new int[size];
        while (i < size && it.hasNext()) {
            int m = it.next();
            if (m != S) {
                res[i] = m;
                i++;
            }
        }
        
        return res;
    }
	
	class UnionFind {
	    int[] parent;
	    
	    public UnionFind(int n) {
	        parent = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	        }
	    }
	    
	    public void union(int a, int b) {
	        int root_a = find(a);
	        int root_b = find(b);
	        if (root_a != root_b) {
	            parent[root_a] = root_b;
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
