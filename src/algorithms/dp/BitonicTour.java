package algorithms.dp;

public class BitonicTour {

	public static void main(String[] args) {
		Point[] points = new Point[] {
				new Point (0, 1),
				new Point (1, 0),
				new Point (2, 2),
				new Point (3, 1)
		};
		
		System.out.println(findBitonicTourPath(points));
	}

	/*
	 * Assume we have n points, from 1 to n, with distinct value of point.x.
	 * Let bd[i][j] be the bitonic distance from i to j, 1 <= i <= n and 1 <= j <= n and i > j.
	 * For each bd[i][j], it must pass through all point between i and j exactly once.
	 * Therefore, bd[i][j] = min { bd[j][i] + distance(i, j) | j > i }
	 * and bd[i][j] = min { bd[i+1][j] + distance(i, i+1), bd[i][j-1] + distance(j-1, j) | i > j }
	 * 
	 */
	private static double findBitonicTourPath (Point[] points) {
		if (points.length == 0) return 0;
		
		int n = points.length;
		double[][] bd = new double[n][n];
		for (int i = 0; i < n; i++) {
			
		}
		
		return 0;
	}
	
	private static double getDistance (Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2));
	}
}
