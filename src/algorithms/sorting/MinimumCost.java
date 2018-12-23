package algorithms.sorting;

import java.util.Arrays;

/**
 * Assume company is organizing a meeting in two cities at the same time, A and B.
 * Both cities can accommodate half of the participants. 
 * Given a list of pair which indicating the cost to these two cities for each participant,
 * find the minimum cost.
 * 
 * Follow up: find the option for each participant.
 * 
 * @author qz
 *
 */
public class MinimumCost {

	public static void main(String[] args) {
		MinimumCost mc = new MinimumCost();
		int[][] costs = {
				{10, 20},
				{20, 30},
				{20, 50},
				{20, 50},
				{80, 50},
				{30, 100},
				{140, 150},
				{70, 80},
				{40, 10},
				{90, 10},
				{100, 30},
				{150, 110},
				{20, 100},
				{10, 20},
				{20, 30}
		};
		
		System.out.println(mc.findMinimumCost_nlgn(costs));
	}
	
	/*
	 *  O(nlogn)
	 *  
	 *  Assume all go to city A, we are trying to select n / 2 participants to go to city B.
	 *  The large of A - B, the more cost will be reduced. 
	 *  
	 */
	public int findMinimumCost_nlgn(int[][] costs) {
		if (costs.length == 0) return 0;
		
		int sum = 0;
		for (int[] cost : costs) {
			sum += cost[0];
		}
		
		Arrays.sort(costs, (a, b) -> b[0] - b[1] - (a[0] - a[1]));
		int n = costs.length;
		for (int i = 0; i < n / 2; i++) {
			sum -= (costs[i][0] - costs[i][1]);
		}
		int mid = costs[n / 2 + 1][0] - costs[n / 2 + 1][1];
		if (mid > 0) {
			sum -= mid;
		}
		
		return sum;
	}
}
