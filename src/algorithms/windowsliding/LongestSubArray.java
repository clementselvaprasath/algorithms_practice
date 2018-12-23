package algorithms.windowsliding;

import java.util.HashMap;
import java.util.Map;

//Longest sub array with distinct element no more than k
public class LongestSubArray {

	public static void main(String[] args) {
		int[] a = {6, 5, 1, 2, 3, 2, 1, 1, 4, 4, 4,4,4,5};
		int k = 3;
		int[] res = getSubArray(a, k);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}
	
	private static int[] getSubArray (int[] a, int k) {
		if (k >= a.length) return a;
		if (k == 1) return new int[]{a[0]};
		int n = a.length;
		
		int start = 0, end = 0, current = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		//{6, 5, 1, 2, 3, 2, 1, 1, 4, 4, 5};
		for(int i = 0; i < n; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
			
			while (map.size() > k) {
				map.put(a[current], map.get(a[current]) - 1);
				if (map.get(a[current]) == 0) {
					map.remove(a[current]);
				}
				current++;
			}
			
			if (max < i - current + 1) {
				max = i - current + 1;
				start = current;
				end = i;
			}
		}
		
		int[] res = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			res[i-start] = a[i];
		}
		
		return res;
	}

}
