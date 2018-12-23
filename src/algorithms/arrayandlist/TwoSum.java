 package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/two-sum/ Given an array of integers, find two
 * numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are zero-based.
 * 
 * Example numbers=[2, 7, 11, 15], target=9
 * 
 * return [0, 1]
 * 
 * Challenge Either of the following solutions are acceptable:
 * 
 * O(n) Space, O(nlogn) Time O(n) Space, O(n) Time
 * 
 * @author qz
 *
 */
public class TwoSum {

	/**
	 * if the array is not sorted
	 * 
	 * @param A
	 * @param T
	 * @return
	 */
	public int[] twoSum_not_sorted(int[] A, int T) {
		// write your code here
		if (A == null || A.length == 0)
			return new int[0];

		// value, index
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				return new int[] { map.get(A[i]), i };
			}
			map.put(T - A[i], i);
		}

		return new int[0];
	}
	
	/**
	 * if the array has been sorted
	 * 
	 * @param A
	 * @param T
	 * @return
	 */
	public int[] twoSum_sorted(int[] A, int T) {
		// write your code here
		if (A == null || A.length == 0)
			return new int[0];

		int i = 0, j = A.length - 1;
		while (i < j) {
			if (A[i] + A[j] == T) return new int[] {i, j};
			else if (A[i] + A[j] > T) j--;
			else i++;
		}

		return new int[0];
	}
}
