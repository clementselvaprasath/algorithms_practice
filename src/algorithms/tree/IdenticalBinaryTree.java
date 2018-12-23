package algorithms.tree;

import algorithms.TreeNode;

/**
 * http://lintcode.com/en/problem/identical-binary-tree/
 * 
 * Check if two binary trees are identical. Identical means the two binary trees
 * have the same structure and every identical position has the same value.
 * 
 * @author qz
 *
 */
public class IdenticalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b == null || a == null && b != null) return false;
        return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
