package algorithms.tree;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes
 from some starting node to any node in the tree along the parent-child connections.
  The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
	 */
	
	int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return res;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(getMaxSum(root.left), 0);
        int right = Math.max(getMaxSum(root.right), 0);
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
