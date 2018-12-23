package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * @author qz
 *
 */
public class StrobogrammaticNumber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Map<String, String> map = new HashMap<>();
	static {
		map.put("0", "0");
		map.put("1", "1");
		map.put("6", "9");
		map.put("8", "8");
		map.put("9", "6");
	}

	// recursive approach
	public List<String> findStrobogrammatic_recursive(int n) {
		if (n == 0)
			return Arrays.asList("");
		if (n == 1)
			return Arrays.asList("0", "1", "8");

		return findStrobogrammatic(n, n);
	}

	public List<String> findStrobogrammatic(int len, int n) {
		if (len == 0)
			return Arrays.asList("");
		if (len == 1)
			return Arrays.asList("0", "1", "8");

		List<String> list = findStrobogrammatic(len - 2, n);
		List<String> res = new ArrayList<>();
		for (String str : list) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (len == n && entry.getKey().equals("0"))
					continue;
				res.add(entry.getKey() + str + entry.getValue());
			}
		}

		return res;
	}

	// iterative approach
	public List<String> findStrobogrammatic(int n) {
		if (n == 0)
			return Arrays.asList("");
		List<String> seed = null;
		if (n % 2 == 0) {
			seed = Arrays.asList("");
		} else {
			seed = Arrays.asList("0", "1", "8");
		}
		for (int i = 2; i <= n; i += 2) {
			seed = updateSeed(seed, n);
		}

		return seed;
	}

	private List<String> updateSeed(List<String> seed, int size) {
		List<String> list = new ArrayList<>();
		for (String str : seed) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String ns = entry.getKey() + str + entry.getValue();
				if (ns.length() == size && ns.charAt(0) == '0')
					continue;
				list.add(ns);
			}
		}
		return list;
	}
}
