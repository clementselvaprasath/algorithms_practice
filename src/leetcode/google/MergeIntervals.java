package leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		System.out.println(true ^ false);
		System.out.println(true ^ true);
		System.out.println(false ^ false);
	}

	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * Example
		Given intervals => merged intervals:
		
		[                     [
		  [1, 3],               [1, 6],
		  [2, 6],      =>       [8, 10],
		  [8, 10],              [15, 18]
		  [15, 18]            ]
		]
	 */
	// min, max
    // if interval.start <= max && interval.end >= min, update min and max
    // else add new interval(min, max)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        for(Interval interval : intervals) {
            if (interval.start <= max && interval.end >= min) {
                max = Math.max(max, interval.end);
            } else {
                res.add(new Interval(min, max));
                min = interval.start;
                max = interval.end;
            }
        }
        res.add(new Interval(min, max));
        
        return res;
    }
}
