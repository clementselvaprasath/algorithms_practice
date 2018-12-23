package leetcode.google;

// clarify the requirements: how many bulbs we need to handle?
// bit manipulation version
public class ToggleBulbs {
	int n;
	
	public ToggleBulbs () {
		n = 0;
	}
	
	public boolean isOn (int i) {
		int tmp = n;
		return ((tmp >> (i - 1)) & 1) == 1;
	}
	
	public void toggle (int start, int end) {
		if (start > 31 || end > 31) return;
		int mask = ((1 << (end - start + 1)) - 1) << (start - 1);
		n = n ^ mask;
		System.out.println(Integer.toBinaryString(n));
	}
	
	public static void main(String[] args) {
		ToggleBulbs tb = new ToggleBulbs();
		int start = 2, end = 6;
		tb.toggle(start, end);
		for (int i = start; i <= end; i++) {
			System.out.println("toggle at " + i + ": " + tb.isOn(i));
		}
	}
}
