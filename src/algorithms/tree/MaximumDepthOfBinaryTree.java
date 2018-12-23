package algorithms.tree;

import algorithms.TreeNode;

/**
 * http://lintcode.com/en/problem/maximum-depth-of-binary-tree/
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.

 * 
 * @author qz
 *
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
