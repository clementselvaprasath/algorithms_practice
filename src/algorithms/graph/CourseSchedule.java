package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/description/
 * @author qz
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        
        int m = prerequisites.length;
        List<Integer>[] graph = new List[numCourses];
        int[] degrees = new int[numCourses];
        
        for (int i = 0; i < m; i++) {
            int[] c = prerequisites[i];
            if (graph[c[1]] == null) {
                graph[c[1]] = new ArrayList<Integer>();
            }
            graph[c[1]].add(c[0]);
            degrees[c[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            count++;
            List<Integer> list = graph[v];
            if (list == null) continue;
            for (int i = 0; i < list.size(); i++) {
                int p = list.get(i);
                degrees[p]--;
                if (degrees[p] == 0) {
                    q.offer(p);
                }
            }
        }
        
        return count == numCourses;
    }
}
