package algorithms;

import java.util.HashMap;
import java.util.Map;

public class RedundantEdge {

	public static void main(String[] args) {
		int[][] input = new int[][]{
			{2,1},
			{3,1},
			{4,2},
			{1,4}
		};
		
		int[] r = findRedundantConnection(input);
		System.out.println(r[0] + "\t" + r[1]);
	}

	public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a0 = findAncestor(map, edge[0]);
            int a1 = findAncestor(map, edge[1]);
            if (a0 != -1 && a1 != -1) {
                if (a0 == a1) return edge;
                else map.put(a1, a0);
            } else if (a0 == -1 && a1 != -1) {
                map.put(edge[0], a1);
            } else if (a1 == -1 && a0 != -1) {
                map.put(edge[1], a0);
            } else {
                map.put(edge[0], edge[0]);
                map.put(edge[1], edge[0]);
            }
        }
        
        return new int[2];
    }
    
    public static int findAncestor (Map<Integer, Integer> map, int val) {
        if (map.get(val) == null) return -1;
        if (map.get(val) == val) {
            return val;
        } else {
            return findAncestor (map, map.get(val));
        }
    }
}
