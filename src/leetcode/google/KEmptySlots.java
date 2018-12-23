package leetcode.google;

import java.util.TreeSet;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N
 * flowers will bloom one by one in N days. In each day, there will be exactly
 * one flower blooming and it will be in the status of blooming since then.
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the
 * array represents the place where the flower will open in that day.
 * 
 * For example, flowers[i] = x means that the unique flower that blooms at day i
 * will be at position x, where i and x will be in the range from 1 to N.
 * 
 * Also given an integer k, you need to output in which day there exists two
 * flowers in the status of blooming, and also the number of flowers between
 * them is k and these flowers are not blooming.
 * 
 * If there isn't such day, output -1.
 * 
 * Example 1:
	Input: 
	flowers: [1,3,2]
	k: 1
	Output: 2
	Explanation: In the second day, the first and the third flower have become blooming.
	Example 2:
	Input: 
	flowers: [1,2,3]
	k: 1
	Output: -1
	Note:
	The given array will be in the range [1, 20000].
 * 
 * @author qz
 *
 */
public class KEmptySlots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kEmptySlots_linear(int[] f, int k) {
		if (k < 0) return -1;
        int n = f.length;
        // days[x] = i, flower at position x bloom at day i
        int[] days = new int[n];
        for (int i = 0; i < days.length; i++) {
            days[f[i] - 1] = i + 1; 
        }
           
        int left = 0, right = left + k + 1, res = Integer.MAX_VALUE;
        for (int i = 1; right < n; i++) {
            if (days[i] > days[left] && days[i] > days[right]) {
                continue;
            }
            if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
            }
            left = i;
            right = left + k + 1;
        }
        
        return res == Integer.MAX_VALUE? -1 : res;
    }

	public int kEmptySlots_nlgn(int[] f, int k) {
        if (k < 0) return -1;
        int n = f.length;

        int dist = k + 1;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(f[i]);
            if (set.lower(f[i]) != null && f[i] - set.lower(f[i]) == dist 
                || set.higher(f[i]) != null && set.higher(f[i]) - f[i] == dist) {
                return i + 1;
            }
        }

        return -1;
    }
}
