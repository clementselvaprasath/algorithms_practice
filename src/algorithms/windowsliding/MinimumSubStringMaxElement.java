package algorithms.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubStringMaxElement {

	public static void main(String[] args) {
		String s = "ababcbcdb";
		System.out.println(findMinimumSubstringDistinctElement2(s));
	}

	private static int findMinimumSubstringDistinctElement (String s) {
		if (s == null || s.length() == 0) return 0;
		char[] a = s.toCharArray();
		int n = a.length;
		int start = 0, min_size = n;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
				while (map.get(a[start]) > 1) {
					map.put(a[start], map.get(a[start]) - 1);
					start++;
				}
				min_size = i - start + 1;
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
		}
		while (map.get(a[start]) > 1) {
			map.put(a[start], map.get(a[start]) - 1);
			start++;
		}
		min_size = Math.min(n - start, min_size);
		return min_size;
	}
	private static int findMinimumSubstringDistinctElement2 (String s) {
		if (s == null || s.length() == 0) return 0;
		char[] a = s.toCharArray();
		int n = a.length;
		int start = 0, min_size = n;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
				while (map.get(a[start]) > 1) {
					map.put(a[start], map.get(a[start]) - 1);
					start++;
				}
			}
			min_size = i - start + 1;
		}
		
		return min_size;
	}
}