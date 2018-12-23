package algorithms.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KSimilarStrings ks = new KSimilarStrings();
		String A = "cdebcdeadedaaaebfbcf";
		String B = "baaddacfedebefdabecc";
		System.out.println(ks.kSimilarity(A, B));
	}

	public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        
        Set<String> visited = new HashSet<>();
        char[] cb = B.toCharArray();

        Queue<String> q = new LinkedList<>();
        q.offer(A);
        visited.add(A);
        int steps = 0, n = cb.length;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
        	    if (s.equals(B)) return steps;
                
                char[] cs = s.toCharArray();
                int start = 0;
                while (cs[start] == cb[start]) {
                	start++;
                }
                for (int j = start + 1; j < n; j++) {
                    if (cs[j] != cb[j] && cs[j] == cb[start]) {
                        swap(cs, start, j);
                        String ns = new String(cs);
                        swap(cs, j, start);
                        if (visited.contains(ns)) continue;
                        q.offer(ns);
                        visited.add(ns);
                    }
                }
            }
            steps++;
        }

        return steps;
    }

	private void swap(char[] c, int i, int j) {
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}
}
