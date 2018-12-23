package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import algorithms.dp.Point;

/**
 * Give a set, if you can find four points that make up a rectangle that is
 * parallel to the coordinate axis and outputs YES or NO.
 * 
 * Notice The number of points in the set is less than 2000, and the coordinate
 * range is [-10000000,10000000].
 * 
 * Example Given set = [[0,0],[0,1],[1,1],[1,0]], return YES.
 * 
 * Explanation: We can find four points that make up a rectangle which is
 * parallel to the coordinate axis. Given set = [[0,0],[0,1],[1,1],[2,0]],
 * return NO.
 * 
 * Explanation: We can not find four points that meet the conditions.
 * 
 * @author qz
 *
 */
public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String rectangle(Point[] pointSet) {
		if (pointSet.length == 0)
			return "NO";
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
		for (Point p : pointSet) {
			if (map.containsKey(p.x)) {
				map.get(p.x).add(p.y);
			} else {
				Set<Integer> set = new TreeSet<>();
				set.add(p.y);
				map.put(p.x, set);
			}
		}

		List<Integer> keys = new ArrayList<>(map.keySet());
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			int x = entry.getKey();
			Set<Integer> ys = entry.getValue();
			for (Integer y : ys) {
				for (int i = keys.size() - 1; i >= 0 && keys.get(i) > x; i--) {
					List<Integer> list = new ArrayList<>(map.get(keys.get(i)));
					for (int j = list.size() - 1; j >= 0 && list.get(j) > y; j--) {
						if (map.get(x).contains(list.get(j)) && map.get(keys.get(i)).contains(y)) {
							return "YES";
						}
					}
				}
			}
		}

		return "NO";
	}

	long hash(int x, int y) {
		return (long) x * 10000000 + y;
	}

	public String rectangle_better(Point[] pointSet) {
		// Write your code here
		Set<Long> hashtable = new HashSet<Long>();
		for (int i = 0; i < pointSet.length; i++) {
			hashtable.add(hash(pointSet[i].x, pointSet[i].y));
		}
		for (int i = 0; i < pointSet.length; i++) {
			for (int j = 0; j < pointSet.length; j++) {
				if (pointSet[i].x < pointSet[j].x && pointSet[i].y < pointSet[j].y) {
					long temp1 = hash(pointSet[i].x, pointSet[j].y);
					long temp2 = hash(pointSet[j].x, pointSet[i].y);
					if (hashtable.contains(temp1) && hashtable.contains(temp2)) {
						return "YES";
					}
				}
			}
		}
		return "NO";
	}
}
