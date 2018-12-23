package algorithms.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example
	Give n = 1, m = 1, limit = 1, cost = [0, 1],return 1.
	
	Explanation:
	Plan 1: planet 0 → planet 1
	Give n = 1, m = 1, limit = 1, cost = [0, 2],return 0.
	
	Explanation:
	He can not reach the target planet.
	Give n = 2, m = 3, limit = 2, cost = [0, 1, 1],return 2.
	
	Explanation:
	Plan 1: planet 0 → planet 1 → planet 2
	Plan 2: planet 0 → planet 2
	Give n = 2, m = 3, limit = 2, cost = [0, 3, 1],return 1.
	
	Explanation:
	Plan 1: planet 0 → planet 2

 * @author qz
 *
 */
public class JumpGameWithCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>[] nodes = new List[1];
	}
	public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        if (n == 0) return 1;
        
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int k = 1; k <= limit && i + k <= n; k++) {
                if (i == 0 && cost[i + k] <= m) {
                    dp[i + k][cost[i + k]] = 1;
                } else {
                    for (int j = 0; j <= m; j++) {
                        if (dp[i][j] > 0 && j + cost[i + k] <= m) {
                            dp[i + k][j + cost[i + k]] += dp[i][j];
                        }
                    } 
                }
            }
        }
        
        long res = 0;
        for (int i = 0; i <= m; i++) {
            res += dp[n][i];
        }
        return res;
    }
	
	
	// MLE
	public long getNumberOfWays_MLE(int n, int m, int limit, int[] cost) {
        if (n == 0) return 1;
        
        Map<Integer, List<Integer>> costMap = new HashMap<>();
        List<Integer> costList = new ArrayList<>();
        costList.add(0);
        costMap.put(0, costList);
        for (int i = 0; i <= n; i++) {
            List<Integer> list = costMap.get(i);
            if(list == null || list.size() == 0) return 0;
            for (int preCost : list) {
                for (int j = i + 1; j <= i + limit && j < cost.length; j++) {
                    int newCost = preCost + cost[j];
                    if (newCost > m) continue;
                    List<Integer> nlist = costMap.getOrDefault(j, new ArrayList<>());
                    nlist.add(newCost);
                    costMap.put(j, nlist);
                }
            }
        }
        
        List<Integer> res = costMap.get(n);
        if (res == null || res.size() == 0) return 0;
        return res.size();
    }
}
