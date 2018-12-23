package leetcode.google;

import algorithms.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * @author qz
 *
 */
public class InorderSuccessorInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode pre = null;
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		
		recursive(root, pre);
	}
	
	public static void recursive (TreeNode root, TreeNode pre) {
		if (root.left == null) return;
		
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || root.left == null && root.right == null) return null;
        
        TreeNode cur = root;
        TreeNode suc = null;

        while (cur != null) {
            if (cur.val <= p.val) {
                cur = cur.right;
            } else {
            	suc = cur;
                cur = cur.left;
            }
        }

        return suc;
    }
	
	public TreeNode successor = null;
    public boolean findP = false;
    public TreeNode inorderSuccessor_Lan(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        inorderSucc(root, p);
        return successor;
    }


    public void inorderSucc(TreeNode root, TreeNode p)
    {
        if(root == null) return;
        inorderSucc(root.left, p);
        if(findP == true && successor == null)
        {
            successor = root;
            return;
        }
        if(root.val == p.val)
        {
            findP = true;
        }
        inorderSucc(root.right,p);
    }
}
