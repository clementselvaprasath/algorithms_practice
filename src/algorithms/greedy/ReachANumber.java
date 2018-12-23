package algorithms.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 754. Reach a Number
 * 
 * You are standing at position 0 on an infinite number line. There is a goal at
 * position target.
 * 
 * On each move, you can either go left or right. During the n-th move (starting
 * from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * Example 1: Input: target = 3 Output: 2 Explanation: On the first move we step
 * from 0 to 1. On the second step we step from 1 to 3. Example 2: Input: target
 * = 2 Output: 3 Explanation: On the first move we step from 0 to 1. On the
 * second move we step from 1 to -1. On the third move we step from -1 to 2.
 * Note: target will be a non-zero integer in the range [-10^9, 10^9].
 * 
 * @author qz
 *
 */
public class ReachANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// greedy
	public int reachNumber_greedy(int target) {
        if (target == 0) return 0;
        int steps = 0, sum = 0;
        target = Math.abs(target);
        while (sum < target) {
            steps++;
            sum += steps;
        }
        while ((sum - target) % 2 == 1) {
            steps++;
            sum += steps;
        }
        return steps;
    }
	
	// level order traversal, TLE
    public int reachNumber(int target) {
        if (target == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int counter = 0;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                int p = q.poll();
                if (p == target) return counter;
                list.add(p - counter - 1);
                list.add(p + counter + 1);
            }
            q.addAll(list);
            counter++;
        }
        
        return counter;
    }
}
