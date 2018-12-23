package algorithms.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.google.Interval;

/**
 * Give two users' ordered online time series, and each section records the
 * user's login time point x and offline time point y. Find out the time periods
 * when both users are online at the same time, and output in ascending order.
 * 
 * Notice We guarantee that the length of online time series meet 1 <= len <=
 * 1e6. For a user's online time series, any two of its sections do not
 * intersect.
 * 
 * Example Given seqA = [[1,2],[5,100]], seqB = [[1,6]], return [[1,2],[5,6]].
 * 
 * Explanation: In these two time periods [1,2],[5,6], both users are online at
 * the same time. Given seqA = [[1,2],[10,15]], seqB = [[3,5],[7,9]], return [].
 * 
 * Explanation: There is no time period, both users are online at the same time.
 * 
 * @author qz
 *
 */
public class TimeIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// sweeping line: convert interval point to node(val, isStart) and sort
	public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        List<Node> list = new ArrayList<>();
        for (Interval in : seqA) {
            list.add(new Node(in.start, true));
            list.add(new Node(in.end, false));
        }
        for (Interval in : seqB) {
            list.add(new Node(in.start, true));
            list.add(new Node(in.end, false));
        }
        
        Collections.sort(list, (a, b) -> {
            if (a.p == b.p) {
                if (a.start == b.start) return 0;
                else if (a.start) return 1;
                else return -1;
            } else {
                return a.p - b.p;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        Node cur = null;
        int k = 2;
        int count = 0;
        for (Node n : list) {
            if (cur == null) {
                cur = n;
            } else {
                // found one
                if (cur.start && !n.start) {
                    if (count == k) {
                        res.add(new Interval(cur.p, n.p));
                        cur = n;
                    }
                } else {
                    cur = n;
                } 
            }
            if (n.start) count++;
            else count--;
        }
        
        return res;
    }
	class Node {
	    int p;
	    boolean start;
	    public Node(int p, boolean start) {
	        this.p = p;
	        this.start = start;
	    }
	}
	
	public List<Interval> timeIntersection_jiuzhang(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        int [] visit = new int[1000001];
        for(int i = 0; i < 1000001; i++) {
            visit[i] = 0;
        }
        for(int i = 0; i < seqA.size(); i++) {
            for(int j = seqA.get(i).start; j <= seqA.get(i).end; j++) {
                visit[j] ++;
            }
        }
        for(int i = 0; i < seqB.size(); i++) {
            for(int j = seqB.get(i).start; j <= seqB.get(i).end; j++) {
                visit[j] ++;
            }
        }
        List<Interval> ans = new ArrayList<>();
        for(int i = 0; i < 1000001; i++) {
            if(visit[i] >= 2) {
                int x = i;
                int y = i;
                while(y + 1 < 1000001 && visit[y + 1] >= 2) {
                    y++;
                }
                ans.add(new Interval(x, y));
                i = y + 1;
            }
        }
        return ans;
    }
}
