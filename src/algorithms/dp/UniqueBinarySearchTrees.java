package algorithms.dp;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author qz
 *
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		UniqueBinarySearchTrees t = new UniqueBinarySearchTrees();
		System.out.println(t.numTrees(2));
	}
	
	// f[n] += 2 * f[k] * f[n - k - 1], k: num of the left node && k = 1,2,...,n/2 - 1
	// if n is odd, f[n] += f[n / 2] * f[n / 2], when nodes of left and right are equal
	public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < i / 2; j++) {
        		dp[i] += 2 * dp[j] * dp[i - 1 - j];
        	}
        	if (i % 2 == 1) {
        		dp[i] += dp[i / 2] * dp[i / 2];
        	}
        }

        return dp[n];
    }
}
