package algorithms.tree;

import algorithms.TreeNode;

public class ContructTreeFromInorderAndLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static TreeNode construct (int[] level, int[] inorder) {
		if (level.length <= 0 || inorder.length <= 0) return null;
		
		TreeNode root = new TreeNode(level[0]);
		int root_index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (level[0] == inorder[i]) {
				root_index = level[0];
				break;
			}
		}
		
		for (int v : level) {
			insert(root, v );
		}
		
		return root;
	}
	
	private static void insert (TreeNode root, int val) {
		if (root.val > val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				insert(root.left, val);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				insert(root.right, val);
			}
		}
	}
}
