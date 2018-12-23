package algorithms;

public class MaxPairProduct {

	public static void main(String[] args) {
		int arr[] = {-1, -3, -4, 2, 0, -5};
		
		int[] res = findMaxPairProduct(arr);
		
		System.out.println(res[0] + "\t" + res[1]);
	}

	public static int[] findMaxPairProduct (int[] p) {
		if (p.length < 2) return new int[2];
		if (p.length == 2) return p;

		int[] maxP = new int[2];
		int[] minN = new int[2];

		int p_index = 0, n_index = 0;
		for (int k = 0; k < p.length; k++) {
			if (p[k] > 0 && p[k] > maxP[p_index]) {
				maxP[p_index] = p[k];
				p_index = 1 - p_index;
			}
			if (p[k] < 0 && p[k] < minN[n_index]) {
				minN[n_index] = p[k];
				n_index = 1 - n_index;
			}
		} 

		return maxP[0] * maxP[1] > minN[0] * minN[1]? maxP : minN;
	}
}
