package leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a
 * / e = ?, a / a = ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 * 
 * According to the example above:
 * 
 * equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0], queries = [
 * ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. The input is
 * always valid. You may assume that evaluating the queries will result in no
 * division by zero and there is no contradiction.
 * 
 * @author qz
 *
 */
public class EvaluateDivision {

	public static void main(String[] args) {
		EvaluateDivision ed = new EvaluateDivision();
		String[][] e = {
				{"a", "b"},
				{"f", "e"},
		};
		double[] v = {2.0, 1.4};
		String[][] q = {
				{"e", "f"}
		};
		System.out.println(Arrays.toString(ed.calcEquation(e, v, q)));
	}

	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] eq = equations[i];
            if (g.containsKey(eq[0])) {
                g.get(eq[0]).put(eq[1], values[i]);
            } else {
                Map<String, Double> map = new HashMap<>();
                map.put(eq[1], values[i]);
                g.put(eq[0], map);
            }
            if (g.containsKey(eq[1])) {
                g.get(eq[1]).put(eq[0], 1 / values[i]);
            } else {
                Map<String, Double> map = new HashMap<>();
                map.put(eq[0], 1 / values[i]);
                g.put(eq[1], map);
            }
        }
        
        double[] res = new double[queries.length];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            if (!g.containsKey(q[0]) || !g.containsKey(q[1])) res[i] = -1.0;
            else res[i] = calc(g, q[0], q[1], visited);
        }
        
        return res;
    }
    
    private double calc(Map<String, Map<String, Double>> g, String start, String end, Set<String> visited) {
        if (start.equals(end)) return 1.0;
        
        Map<String, Double> edges = g.get(start);
        for (String s : edges.keySet()) {
            if (visited.contains(s)) continue;
            visited.add(s);
            double v = calc(g, s, end, visited);
            visited.remove(s);
            if (v > 0) return edges.get(s) * v;
        }
        
        return -1.0;
    }
}
