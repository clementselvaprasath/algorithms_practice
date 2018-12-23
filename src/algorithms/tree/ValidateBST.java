package algorithms.tree;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (root.left != null && root.val <= getPredecessor(root).val
            || root.right != null && root.val >= getSuccessor(root).val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
    private static TreeNode getPredecessor(TreeNode root) {
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    private static TreeNode getSuccessor(TreeNode root) {
        TreeNode p = root.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
