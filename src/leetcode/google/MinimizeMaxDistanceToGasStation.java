package leetcode.google;

import java.util.PriorityQueue;

/**
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * Example:
 * 
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9 Output: 0.500000
 * Note:
 * 
 * stations.length will be an integer in range [10, 2000]. stations[i] will be
 * an integer in range [0, 10^8]. K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * @author qz
 *
 */
public class MinimizeMaxDistanceToGasStation {

	//[0,2,16,18,44,63,80,84,90,94]
	//9
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// binary search logM, m = max of distance
	public double minmaxGasDist_binarysearch(int[] stations, int K) {
        int n = stations.length;
        double min = 0, max = Integer.MIN_VALUE, mid = 0;
        int[] dist = new int[n - 1];
        for (int i = 1; i < n; i++) {
            dist[i - 1] = stations[i] - stations[i - 1];
            min = Math.min(min, dist[i - 1]);
            max = Math.max(max, dist[i - 1]);
        }
        while (max - min > 1e-6) {
            mid = (max + min) / 2;
            if (isPossible(dist, mid, K)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        
        return max;
    }
    
    private boolean isPossible(int[] dist, double mid, int K) {
        int used = 0;
        for (int i = 0; i < dist.length; i++) {
            used += dist[i] / mid;
        }
        return used <= K;
    }
	
	
	// PriorityQueue, TLE, nlogn + Klogn
	public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;

        PriorityQueue<Distance> pq = new PriorityQueue<>((d1, d2) -> {
            if (Math.abs(d2.val - d1.val) < 1e-6) {
                return d2.div - d1.div;
            } else {
                if (d2.val > d1.val) return 1;
                else return -1;
            }
        });
        for (int i = 1; i < n; i++) {
            double d = (stations[i] - stations[i - 1]) * 1.0;
            pq.offer(new Distance(d, 1));
        }

        for (int i = 0; i < K; i++) {
            Distance distance = pq.poll();
            distance.val = distance.val * distance.div / (distance.div + 1);
            distance.div = distance.div + 1;
            pq.offer(distance);
        }

        return pq.poll().val;
    }
	class Distance{
	    double val;
	    int div;
	    public Distance (double val, int div) {
	        this.val = val;
	        this.div = div;
	    }
	}
}
