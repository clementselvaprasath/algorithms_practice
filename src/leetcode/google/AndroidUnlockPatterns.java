package leetcode.google;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤
 * n ≤ 9, count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern: Each pattern must connect at least m keys and at
 * most n keys. All the keys must be distinct. If the line connecting two
 * consecutive keys in the pattern passes through any other keys, the other keys
 * must have previously selected in the pattern. No jumps through non selected
 * key is allowed. The order of keys used matters.
 * 
 * Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
 * 
 * @author qz
 *
 */
public class AndroidUnlockPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 1,3,5,7 and 2,4,6,8 are the same
	 */
	public int numberOfPatterns(int m, int n) {
        if (m > n || m > 9 || n == 0) return 0;
        if (m == 9) return 1;
        int ans = 0;
        boolean[] selected = new boolean[9];
        for (int i = m; i <= n; i++) {
            ans += 4 * dfs(selected, 0, m, i - 1);
            ans += 4 * dfs(selected, 1, m, i - 1);
            ans += dfs(selected, 4, m, i - 1);
        }
        
        return ans;
    }
    
    private int dfs(boolean[] selected, int last, int m, int remains) {
        if (remains < 0) return 0;
        if (remains == 0) return 1;
        int total = 0;
        selected[last] = true;
        for (int i = 0; i < 9; i++) {
            if (isValid(selected, last, i)) {
                total += dfs(selected, i, m, remains - 1);
            }
        }
        selected[last] = false;
        
        return total;
    }
    
    private boolean isValid(boolean[] selected, int last, int choice) {
        if (selected[choice]) return false;
        if (last / 3 == choice / 3 && Math.abs(last - choice) == 2) {
            if (!selected[(last + choice) / 2]) return false;
            else return true;
        }
        if (last % 3 == choice % 3 && Math.abs(last - choice) == 6) {
            if (!selected[(last + choice) / 2]) return false;
            else return true;
        }
        if (last + choice == 8) {
            if (!selected[4]) return false;
            else return true;
        }
        return true;
    }
}
