package leetcode.google;

import java.util.TreeSet;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * 
 * Example 1:
 * 
 * Input: "19:34" Output: "19:39" Explanation: The next closest time choosing
 * from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not
 * 19:33, because this occurs 23 hours and 59 minutes later. Example 2:
 * 
 * Input: "23:59" Output: "22:22" Explanation: The next closest time choosing
 * from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is
 * next day's time since it is smaller than the input time numerically.
 * 
 * 
 * @author qz
 *
 */
public class NextClosestTime {

	public String nextClosestTime(String time) {
		char[] c = time.toCharArray();

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i]))
				set.add(c[i] - '0');
		}

		String[] t = time.split(":");
		int hour = Integer.parseInt(t[0]);
		int mins = Integer.parseInt(t[1]);

		int mins_l = mins / 10, mins_r = mins % 10;
		int hour_l = hour / 10, hour_r = hour % 10;

		if (set.higher(mins_r) != null) {
			return generateNewTime(hour_l, hour_r, mins_l, set.higher(mins_r));
		}
		mins_r = set.first();

		if (set.higher(mins_l) != null && set.higher(mins_l) * 10 + mins_r < 60) {
			return generateNewTime(hour_l, hour_r, set.higher(mins_l), mins_r);
		}
		mins_l = set.first();

		if (set.higher(hour_r) != null && hour_l * 10 + set.higher(hour_r) < 24) {
			return generateNewTime(hour_l, set.higher(hour_r), mins_l, mins_r);
		}
		hour_r = set.first();

		if (set.higher(hour_l) != null && set.higher(hour_l) * 10 + hour_r < 24) {
			return generateNewTime(set.higher(hour_l), hour_r, mins_l, mins_r);
		}
		hour_l = set.first();

		return generateNewTime(hour_l, hour_r, mins_l, mins_r);
	}

	private String generateNewTime(int hour_l, int hour_r, int mins_l, int mins_r) {
		StringBuilder sb = new StringBuilder();
		sb.append(hour_l).append(hour_r).append(":").append(mins_l).append(mins_r);
		return sb.toString();
	}
}
