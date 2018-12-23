package leetcode.amazon;

/**
 * You have n super washing machines on a line. Initially, 
 * each washing machine has some dresses or is empty.

For each move, you could choose any m (1 ≤ m ≤ n) washing machines, 
and pass one dress of each washing machine to one of its adjacent washing 
machines at the same time .

Given an integer array representing the number of dresses in each 
washing machine from left to right on the line, you should find the minimum 
number of moves to make all the washing machines have the same number of dresses. 
If it is not possible to do it, return -1.

Example1

Input: [1,0,5]

Output: 3

Explanation: 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
3rd move:    2     1 <-- 3    =>    2     2     2   
Example2

Input: [0,3,0]

Output: 2

Explanation: 
1st move:    0 <-- 3     0    =>    1     2     0    
2nd move:    1     2 --> 0    =>    1     1     1     
Example3

Input: [0,2,0]

Output: -1

Explanation: 
It's impossible to make all the three washing machines have the same number of dresses. 
Note:
The range of n is [1, 10000].
The range of dresses number in a super washing machine is [0, 1e5].
 * @author qz
 *
 */
public class SuperWashingMachines {

	/*
	 * dp[i]: minimum moves at position i. dp[0] = m[0] - avg, sum[i] = sum(0, i)
	 * when i > 0
	 * 1. if m[i] - avg > 0, dp[i] = max(dp[i - 1], m[i] - avg)
	 * 2. if m[i] - avg < 0, dp[i] = max(dp[i - 1], abs(sum[i]))
	 * 3. if m[i] - avg = 0, dp[i] = dp[i - 1]
	 */
	public int findMinMoves(int[] machines) {
        int n = machines.length;
		if (n == 0) return 0;

		int sum = 0;
		for (int m : machines) {
			sum += m;
		}
		if (sum % n != 0) return -1;

		int ans = 0, count = 0, avg = sum / n;
		for (int m : machines) {
			count += m - avg;
            ans = Math.max(ans, Math.max(Math.abs(count), m - avg));
		}

		return ans;
    }
}
