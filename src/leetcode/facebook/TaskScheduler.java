package leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 *
 * Example 1:
	Input: tasks = ['A','A','A','B','B','B'], n = 2
	Output: 8
	Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
	Note:
	The number of tasks is in the range [1, 10000].
	The integer n is in the range [0, 100].
 * 
 * @author qz
 *
 */
public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}

	public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length; 
        
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int idle = (map[25] - 1) * n;
        for (int i = 24; i >= 0; i--) {
            if (map[i] == 0) break;
            idle -= Math.min(map[25] - 1, map[i]);
            if (idle <= 0) return tasks.length;
        }

        return idle + tasks.length;
    }
	
	public int leastInterval_priorityQueue(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length; 
        
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) pq.offer(map[i]);
        }
        
        int total = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            while (i <= n) {
                if (pq.isEmpty() && tmp.isEmpty()) break;
                if (!pq.isEmpty()) {
                    int t = pq.poll();
                    if (t > 1) {
                        tmp.add(t - 1);
                    }
                }
                total++;
                i++;
            }
            pq.addAll(tmp);
        }
        
        return total;
    }
}
