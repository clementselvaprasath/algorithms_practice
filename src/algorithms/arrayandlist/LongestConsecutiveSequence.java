package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author qz
 *
 */
public class LongestConsecutiveSequence {

	// O(n)
	/**
	 * First turn the input into a set of numbers. That takes O(n) and then we can
	 * ask in O(1) whether we have a certain number.
	 * 
	 * Then go through the numbers. If the number x is the start of a streak (i.e.,
	 * x-1 is not in the set), then test y = x+1, x+2, x+3, ... and stop at the
	 * first number y not in the set. The length of the streak is then simply y-x
	 * and we update our global best with that. Since we check each streak only
	 * once, this is overall O(n). This ran in 44 ms on the OJ, one of the fastest
	 * Python submissions.
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public int longestConsecutive(int[] num) {
		if (num.length <= 1)
			return num.length;

		Set<Integer> set = new HashSet<>();
		for (int n : num) {
			set.add(n);
		}

		int max = 1, end = 0;
		for (int n : num) {
			if (!set.contains(n - 1)) {
				end = n;
				while (set.contains(end)) {
					end++;
				}
				max = Math.max(max, end - n);
			}
		}

		return max;
	}

	public int longestConsecutive_unionfind(int[] num) {
		if (num.length <= 1)
			return num.length;

		UnionFind uf = new UnionFind(num);
		for (int n : num) {
			uf.union(n - 1, n);
			uf.union(n, n + 1);
		}

		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for (int n : uf.parent.keySet()) {
			int k = uf.find(n);
			map.put(k, map.getOrDefault(k, 0) + 1);
			max = Math.max(max, map.get(k));
		}

		return max;
	}

	private class UnionFind {
		Map<Integer, Integer> parent = new HashMap<>();

		public UnionFind(int[] num) {
			for (int n : num) {
				parent.put(n, n);
			}
		}

		public void union(int a, int b) {
			if (!parent.containsKey(a) || !parent.containsKey(b))
				return;
			int root_a = find(a);
			int root_b = find(b);
			if (root_a != root_b) {
				parent.put(root_a, root_b);
			}
		}

		public int find(int a) {
			if (parent.get(a) == a) {
				return a;
			}
			parent.put(a, find(parent.get(a)));
			return parent.get(a);
		}
	}
}
