package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumRiskPath {

	public static void main(String[] args) {
		MinimumRiskPath ins = new MinimumRiskPath();
		int n = 15, m = 119;
		int[] x = {0,0,3,0,1,5,5,0,11,0,1,5,12,2,12,3,14,9,4,1,2,10,0,6,10,2,2,8,9,13,4,14,13,7,0,9,8,0,2,0,13,12,11,5,14,14,0,3,10,5,4,12,12,1,14,10,10,12,5,6,15,11,2,1,3,9,11,12,10,14,6,10,12,1,4,1,8,10,3,9,13,4,10,6,4,6,3,13,7,9,13,3,4,7,7,15,2,6,6,1,15,15,2,3,6,14,9,11,2,5,15,2,7,15,3,1,5,1,13};
		int[] y = {15,7,8,11,0,0,4,10,2,9,4,14,4,12,8,1,8,2,8,5,0,4,8,11,13,4,8,10,7,14,6,6,6,8,13,13,5,12,14,14,8,7,14,10,12,15,6,0,2,12,0,11,10,8,7,1,11,15,11,8,5,13,13,14,11,12,7,3,7,10,12,3,13,15,11,11,9,6,5,6,15,9,15,15,14,3,15,7,4,10,5,4,13,1,3,8,3,5,1,12,4,9,15,14,7,9,5,8,6,7,11,1,2,7,9,9,2,13,3};
		int[] w = {98737,25594,93437,6242,4021,85593,49106,80313,86433,7439,63281,66498,11065,55961,40850,36571,53394,48551,75802,45577,50801,16246,99905,12301,95430,46641,15151,66858,26256,61817,26241,53249,36038,17433,15939,39647,3031,71721,71546,40145,16385,42928,74959,29414,38973,10676,72912,82047,22241,87633,99101,23241,42017,79035,23283,37164,57041,66185,47929,88161,55180,63622,52383,94641,81217,83186,58081,57311,55057,68722,84161,29662,96779,86373,71657,65761,78376,52239,6321,11433,27204,74425,99619,71926,91136,90313,26470,64601,61665,62077,75091,33121,69401,49817,47741,90683,8929,78939,52716,52917,96033,40497,65485,75320,1461,19905,37603,4353,39366,70546,30517,72611,71431,86347,57675,86309,71521,73945,67151};
		System.out.println(ins.getMinRiskValue(n, m, x, y, w));
	}

	int min = Integer.MAX_VALUE;
    public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
         Map<Integer, Node> map = new HashMap<>();
         for (int i = 0; i <= n; i++) {
             map.put(i, new Node(i));
         }
         for (int i = 0; i < m; i++) {
             Node n1 = map.get(x[i]);
             Node n2 = map.get(y[i]);
             n1.adj.add(new Edge(x[i], y[i], w[i]));
             n2.adj.add(new Edge(y[i], x[i], w[i]));
         }
//        int[][] graph = new int[n + 1][n + 1];
//        for (int i = 0; i < m; i++) {
//            graph[x[i]][y[i]] = w[i];
//            graph[y[i]][x[i]] = w[i];
//        }
        boolean[] visited = new boolean[n + 1];
        //search(0, 0, n, graph, visited);
        dfs(map.get(0), 0, n, map, visited);
        return min;
    }
    private void search (int cur, int maxNow, int target, int[][] graph, boolean[] visited) {
        if (cur == target) {
            min = Math.min(min, maxNow);
            return;
        }
        visited[cur] = true;
        for (int j = 0; j < graph[cur].length; j++) {
            if (graph[cur][j] > 0 && !visited[j] && graph[cur][j] < min) {
                search(j, Math.max(maxNow, graph[cur][j]), target, graph, visited);
            }
        }
        visited[cur] = false;
    }
    private void dfs(Node node, int maxNow, int target, Map<Integer, Node> map, boolean[] visited) {
        if (node.label == target) {
            min = Math.min(min, maxNow);
            return;
        }
        visited[node.label] = true;
        for (Edge edge : node.adj) {
            if (!visited[edge.end] && min > edge.weight) {
                dfs(map.get(edge.end), Math.max(maxNow, edge.weight), target, map, visited);
            }
        }
        visited[node.label] = false;
    }
    
    class Node {
        int label;
        List<Edge> adj;
        public Node (int label) {
            this.label = label;
            adj = new ArrayList<>();
        }
    }
    class Edge {
        int start, end, weight;
        public Edge (int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
