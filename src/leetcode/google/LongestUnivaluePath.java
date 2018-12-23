package leetcode.google;

import algorithms.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * Example 1:

	Input:
	
	              5
	             / \
	            4   5
	           / \   \
	          1   1   5
	Output:
	
	2
	Example 2:
	
	Input:
	
	              1
	             / \
	            4   5
	           / \   \
	          4   4   5
	Output:
	
	2
 * 
 * @author qz
 *
 */
public class LongestUnivaluePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int left = 0, right = 0, current = 0, cross = 0;
        if (root.left != null) {
            left = dfs(root.left);
            if (root.val == root.left.val) {
                current = left + 1;
                cross = left + 1;
            }
        }
        if (root.right != null) {
            right = dfs(root.right);
            if (root.val == root.right.val) {
                current = Math.max(current, right + 1);
                cross += right + 1;
            }
        }
        
        res = Math.max(res, Math.max(current, cross));
        return current;
    }
}
