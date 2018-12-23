package algorithms.dp;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Throw n dices, the sum of the dices' faces is S. Given n, find the all
 * possible value of S along with its probability.
 * 
 * Notice You do not care about the accuracy of the result, we will help you to
 * output results.
 * 
 * Example Given n = 1, return [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5,
 * 0.17], [6, 0.17]].
 * 
 * @author qz
 *
 */
public class DicesSum {

	// Write your code here
	// Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
	// to create the pair
	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
		
		// f[i][j]: i dices for j value
		// f[i][j] = 1 when i == 1
		// f[i][j] = sum (f[i - 1][j - k] for each j >= k, k >= 1 && k <= 6) 
		List<Map.Entry<Integer, Double>> res = new ArrayList<>();
		if (n == 0) return res;

		long sum = (long) Math.pow(6, n);
		int max = n * 6;
		long[][] f = new long[n + 1][max + 1];
		for (int i = 0; i <= max; i++) {
			f[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1 * i; j <= i * 6; j++) {
				if (i == 1) {
					f[i][j] = 1;
					continue;
				}
				for (int k = 1; k <= 6; k++) {
					if (j >= k)
						f[i][j] += f[i - 1][j - k];
				}
			}
		}

		for (int i = n; i <= max; i++) {
			res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, f[n][i] * 1.0 / sum));
		}

		return res;
	}

}
