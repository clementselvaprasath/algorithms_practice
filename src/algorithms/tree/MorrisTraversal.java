package algorithms.tree;

import java.util.List;

public class MorrisTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void morrisTraversal_Inorder(TreeNode root, List<TreeNode> list) {
		if (root == null) return;
		TreeNode current = root;
		TreeNode pre = null;
		
		while (current != null) {
			// find the left most node
			if (current.left == null) {
				list.add(current);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				
				// not linked, link it to current now
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} 
				// linked and found, restore the tree
				else {
					pre.right = null;
					list.add(current);
					current = current.right;
				}
			}
		}
		
	}
	
	public void morrisTraversal_Preorder(TreeNode root, List<TreeNode> list) {
		if (root == null) return;
		TreeNode current = root;
		TreeNode pre = null;
		
		while (current != null) {
			// find the left most node
			if (current.left == null) {
				list.add(current);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				// not linked and found, link now and output now
				if (pre.right == null) {
					pre.right = current;
					list.add(current);
					current = current.left;
				} 
				// linked, unlink it
				else {
					pre.right = null;
					current = current.right;
				}
			}
		}
		
	}
}
