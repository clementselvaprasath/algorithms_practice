package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integer, and a moving window(size k), move the window at
 * each iteration from the start of the array, find the sum of the element
 * inside the window at each moving.
 * 
 * Have you met this question in a real interview? Example For array
 * [1,2,7,8,5], moving window size k = 3. 1 + 2 + 7 = 10 2 + 7 + 8 = 17 7 + 8 +
 * 5 = 20 return [10,17,20]
 * 
 * @author qz
 *
 */
public class WindowSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] winSum(int[] nums, int k) {
        // write your code here
        if (k == 0 || nums.length == 0) return new int[0];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int init = 0;
        for (int i = 0; i < Math.min(k, n); i++) {
            map.put(i, nums[i]);
            init += nums[i];
        }
        if (n - k <= 0) return new int[]{init};
        int[] res = new int[n - k + 1];
        res[0] = init;
        for (int i = 1; i < n - k + 1; i++) {
            res[i] = res[i - 1] + nums[i + k - 1] - map.get(i - 1);
            map.remove(i - 1);
            map.put(i + k - 1, nums[i + k - 1]);
        }
        return res;
    }
}
