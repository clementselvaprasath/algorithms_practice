package leetcode.google;

public class MagicNumberSequence {
	
	public static void main(String[] args) {
		MagicNumberSequence m = new MagicNumberSequence();
		System.out.println(m.steps(3));
	}
	
	public int steps(int n) {
		if (n == 1) return 0;
		
		if (n % 2 == 0) {
			return steps(n / 2) + 1;
		} else {
			return steps(n * 3 + 1) + 1;
		}
	}
	
}
