package algorithms.dp;

public class CuttingRod {

	public static void main(String[] args) {
		int[] prices = new int[]{1,5,8,9,10,17,17,20,24,30};
		int length = 20;
		for(int i = 1; i <= length; i++) {
			System.out.println(cuttingRodBottomUp(prices, i, new int[i+1]));
		}
	}
	
	private static int cuttingRodTopDown(int[] p, int length, int[] mem) {
		if(length < 1) return 0;
		if(mem[length] > 0) return mem[length];
		int q = Integer.MIN_VALUE;
		for(int i = 1; i <= length; i++) {
			if(i > p.length) {
				q = Math.max(q, cuttingRodTopDown(p, i, mem) + cuttingRodTopDown(p, length - i, mem));
			} else {
				q = Math.max(q, p[i-1] + cuttingRodTopDown(p, length - i, mem));
			}
		}
		mem[length] = q;
		return q;
	}

	private static int cuttingRodBottomUp(int[] p, int length, int[] mem) {
		if(length < 1) return 0;
		
		for(int j = 1; j <= length; j++) {
			int q = Integer.MIN_VALUE;
			for(int i = 1; i <= j; i++) {
				if(i > p.length) {
					q = Math.max(q, mem[i] + mem[j-i]);
				} else {
					q = Math.max(q, p[i-1] + mem[j-i]);
				}
			}
			mem[j] = q;
		}
		
		return mem[length];
	}
}
