package algorithms.tree;

import algorithms.TreeNode;

/**
 * http://lintcode.com/en/problem/clone-binary-tree/
 * @author qz
 *
 */
public class CloneBinaryTree {

	public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) return null;
        TreeNode nn = new TreeNode(root.val);
        nn.left = cloneTree(root.left);
        nn.right = cloneTree(root.right);
        return nn;
    }
}
