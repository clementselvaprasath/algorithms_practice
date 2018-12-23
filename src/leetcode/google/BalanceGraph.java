package leetcode.google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a directed graph where each edge is represented by a tuple, such as [u, v, w]represents an edge with a weight w from u to v.
You need to calculate at least the need to add the number of edges to ensure that each point of the weight are balancing. That is, the sum of weight of the edge pointing to this point is equal to the sum of weight of the edge of the point that points to the other point.

 Notice
1.Note that u ≠ v and w > 0.
2.index may not be linear, e.g. we could have the points 0, 1, 2 or we could also have the points 0, 2, 6.

Example
For example:
Given a graph [[0,1,10],[2,0,5]] 
Return 2
Two edges are need to added. There are [1,0,5] and [1,2,5]

Given a graph [[0,1,10],[1,0,1],[1,2,5],[2,0,5]] 
Return 1
Only one edge need to added. There is [1,0,4]
 */
public class BalanceGraph {

	public static void main(String[] args) {
		int[][] e = {
				{9,8,1},{6,8,59},{5,4,28},{5,4,43},{0,2,54},{4,3,17},{9,8,72},{0,1,68},{4,3,4},{2,0,74},{7,9,54},{5,4,58},{1,2,42},{4,5,91},{0,1,41},{6,8,6},{7,8,51},{0,2,30},{6,8,57},{8,6,32}
			};
		
		System.out.println(balanceGraph(e));
	}

	
	public static int balanceGraph(int[][] edges) {
        if (edges == null || edges.length == 0) return 0; 

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
        	map.put(edge[0], map.getOrDefault(edge[0], 0) - edge[2]);
        	map.put(edge[1], map.getOrDefault(edge[1], 0) + edge[2]);
        }

     	PriorityQueue<Map.Entry<Integer, Integer>> max_pos = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
	     	public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
	     		return e2.getValue() - e1.getValue();
	     	}
    	});

    	PriorityQueue<Map.Entry<Integer, Integer>> min_neg = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
	     	public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
	     		return e1.getValue() - e2.getValue();
	     	}
    	});

    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		if (entry.getValue() > 0) {
    			max_pos.offer(entry);
    		}
    		if (entry.getValue() < 0) {
    			min_neg.offer(entry);
    		}
    	}

    	int res = 0;
    	while (!max_pos.isEmpty() && !min_neg.isEmpty()) {
    		Map.Entry<Integer, Integer> pos = max_pos.poll();
    		Map.Entry<Integer, Integer> neg = min_neg.poll();
    		int v = Math.min(pos.getValue(), 0 - neg.getValue());
    		pos.setValue(pos.getValue() - v);
    		neg.setValue(neg.getValue() + v);
    		if (pos.getValue() > 0) {
    			max_pos.offer(pos);
    		}
    		if (neg.getValue() < 0) {
    			min_neg.offer(neg);
    		}
    		res++;
    	}

    	return res;
    }
}
