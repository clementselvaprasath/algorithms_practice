package leetcode.facebook;

public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingDistance(int x, int y) {
        if (x == y) return 0;
        int c = x ^ y;
        int ans = 0;
        while (c != 0) {
            c &= c - 1;
            ans++;
        }
        
        return ans;
    }
}
