package algorithms.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leetcode.google.Interval;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * Input: [[0, 30],[5, 10],[15, 20]] Output: 2 Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: 1
 * 
 * @author qz
 *
 */
public class MeetingRooms_II {

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0)
			return 0;

		List<int[]> events = new ArrayList<>();
		for (Interval i : intervals) {
			events.add(new int[] { i.start, 1 });
			events.add(new int[] { i.end, -1 });
		}

		Collections.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
		int ans = 0, count = 0;
		for (int[] e : events) {
			count += e[1];
			ans = Math.max(ans, count);
		}

		return ans;
	}

	public int minMeetingRooms_split(Interval[] intervals) {
		int res = 0;
		if (intervals == null || intervals.length == 0)
			return res;
		int n = intervals.length;
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		for (int end = 0, ptr = 0; ptr < n; ptr++) {
			if (starts[ptr] < ends[end]) {
				res++;
			} else {
				end++;
			}
		}

		return res;
	}
}
