package leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 * @author qz
 *
 */
public class PossibleBipartition {
	
	public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N == 0) return false;

        List<Integer>[] graph = new List[N + 1];
        for (int[] d : dislikes) {
        	if (graph[d[0]] == null) {
        		graph[d[0]] = new ArrayList<>();
        	}
            if (graph[d[1]] == null) {
                graph[d[1]] = new ArrayList<>();
            }
        	graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        int[] color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (graph[i] == null) continue;
        	if (color[i] == 0 && !canPartition(graph, color, i, 1)) {
        		return false;
        	}
        }

        return true;
    }

    private boolean canPartition(List<Integer>[] graph, int[] color, int p, int c) {
    	color[p] = c;
    	for (Integer i : graph[p]) {
    		if (color[i] == c) return false;
    		if (color[i] == 0 && !canPartition(graph, color, i, -c)) return false;
    	}

    	return true;
    }
}