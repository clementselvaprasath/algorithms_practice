package algorithms.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 2, 3};
		int k = 3;

		int[] res = getSmallestSubArray(a, k);
		System.out.println(res[0] + "\t" + res[1]);
	}

	private static int[] getSmallestSubArray (int[] a, int k) {
		if (a == null) return null;
		int n = a.length;
		int start = 0, end = 0, dis = n, cur = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
			
			while (i - cur + 1 > k) {
				if (map.size() == k && map.get(a[cur]) == 1) break;
				map.put(a[cur], map.get(a[cur]) - 1);
				if (map.get(a[cur]) == 0) map.remove(a[cur]);
				cur++;
			}
			
			if (dis >= i - cur + 1 && map.size() == k) {
				dis = i - cur + 1;
				start = cur;
				end = i;
			}
		}
		
		return new int[]{start, end};
	}
}
