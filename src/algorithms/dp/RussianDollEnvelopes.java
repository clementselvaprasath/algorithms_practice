package algorithms.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		int[][] a = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelopes(a));
	}

	/*
	 * You have a number of envelopes with widths and heights given as a pair of
	 * integers (w, h). One envelope can fit into another if and only if both
	 * the width and height of one envelope is greater than the width and height
	 * of the other envelope.
	 * 
	 * What is the maximum number of envelopes can you Russian doll? (put one
	 * inside other)
	 * 
	 * Example Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number
	 * of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
	 * 
	 * 
	 */
	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
        });
        int n = envelopes.length;
        int[] f = new int[n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            for(int i = 0; i < j; i++) {
                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1] && f[j] < f[i] + 1) {
                    f[j] = f[i] + 1;
                }
            }
            max = Math.max(max, f[j]);
        }
        
        return max;
	}
}
