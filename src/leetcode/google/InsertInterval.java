package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a non-overlapping interval list which is sorted by start point.
	 * 
	 * Insert a new interval into it, make sure the list is still in order and
	 * non-overlapping (merge intervals if necessary).
	 * 
	 * Example 
	 * Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
	 * 
	 * Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
	 */
	
	
	public static List<Interval> insert(List<Interval> intervals, Interval newi) {
		if (intervals == null || newi == null) {
    		return intervals;
    	}
    	
    	List<Interval> res = new ArrayList<Interval>();
    	int pos = 0;;
    	for (Interval interval : intervals) {
    		if (interval.end < newi.start) {
    			res.add(interval);
    			pos++;
    		} else if (newi.end < interval.start) {
    			res.add(interval);
    		} else {
    			newi.start = Math.min(newi.start, interval.start);
    			newi.end = Math.max(newi.end, interval.end);
    		}
    	}
    	res.add(pos, newi);
    
    	return res;
	}
}