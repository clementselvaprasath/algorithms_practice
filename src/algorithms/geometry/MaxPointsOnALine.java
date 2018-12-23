package algorithms.geometry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import algorithms.dp.Point;

public class MaxPointsOnALine {
	
	public static void main(String[] args) {
		//[[0,0],[1,65536],[65536,0]]
		MaxPointsOnALine mm = new MaxPointsOnALine();
		Point[] ps = new Point[] {
				new Point(3, 1),
				new Point(3, 1),
				new Point(-6, -1),
				new Point(12, 3)
		};
		Point[] ps2 = new Point[] {
				new Point(0, 0),
				new Point(0, 0)
		};
		System.out.println(mm.maxPoints(ps));
	}
	
	public int maxPoints(Point[] points) {
		if (points.length <= 1) return points.length;
        
        int n = points.length, max = Integer.MIN_VALUE;
        Arrays.sort(points, (a, b) -> a.x - b.x);
        for (int i = 0; i < n; i++) {
        	Map<String, Integer> map = new HashMap<>();
        	int same = 0;
        	int count = 1;
        	for (int j = i + 1; j < n; j++) {
        		int dy = points[j].y - points[i].y;
        		int dx = points[j].x - points[i].x;

        		String key = "";
        		if (dy == 0 && dx == 0) {
        			same++;
        			continue;
        		} else if (dx == 0) {
        			key = "x=" + points[j].x;
        		} else if (dy == 0) {
					key = "y=" + points[j].y;
        		} else {
        			int d = getGCD(dy, dx);
        			double a = (dy / d) * 1.0 / (dx / d);
        			double b = points[j].y - points[j].x * a;
        			key = a + "," + b;
        		}
        		map.put(key, map.getOrDefault(key, 1) + 1);
        		count = Math.max(count, map.get(key)); 
        	}
        	max = Math.max(max, count + same);
        }

        return max;
    }
	
	private int getGCD(int a, int b) {
		if (b == 0) return a;
		return getGCD(b, a % b);
	}
}
