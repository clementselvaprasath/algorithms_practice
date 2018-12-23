package leetcode.amazon;

/**
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @author qz
 *
 */
public class CountPrimes {

	public int countPrimes_2(int n) {
		int count = 0;
		boolean[] nonprime = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (nonprime[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {
					nonprime[i * j] = true;
				}
			}
		}
		return count++;
	}

	public int countPrimes_1(int n) {
		if (n <= 1)
			return 0;
		int l = (int) Math.sqrt(n);
		boolean[] visited = new boolean[n];

		for (int i = 2; i <= l; i++) {
			for (int j = i; i * j < n; j++) {
				visited[i * j] = true;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!visited[i])
				count++;
		}
		return count;
	}
}
