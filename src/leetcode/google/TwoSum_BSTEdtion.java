package leetcode.google;

import algorithms.TreeNode;

public class TwoSum_BSTEdtion {

	public static void main(String[] args) {
		int[] v = {4,2,5,1,3};
		int t = 9;
		TreeNode root = TreeNode.buildTree(v);
		int[] res = twoSum(root, t);
		System.out.println(res[0] + ", " + res[1]);
	}

	/*
	 * Given a binary search tree and a number n, find two numbers in the tree
	 * that sums up to n.
	 * 
	 *  Notice
Without any extra space.
	 * 
	 * Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
and a number n = 3
return [1, 2] or [2, 1]
	 */
	public static int[] twoSum(TreeNode root, int n) {
    	if (root == null) return null;
    	int[] res = new int[2];
    	if (root.left == null && root.right == null) return res;
    	TreeNode l = getMinimum(root);
    	TreeNode r = getMaximum(root);
    	int sum = 0;
    	while (l.val < r.val) {
    		sum = l.val + r.val;
    		if (sum < n) {
    			l = getSuccessor(root, l);
    		} else if (sum > n) {
    			r = getPredecessor(root, r);
    		} else {
    			break;
    		}
    	}
    	
    	res[0] = l.val;
    	res[1] = r.val;
    	return res;
    }

	private static TreeNode getPredecessor(TreeNode root, TreeNode n) {
    	if (n == null) return null;
    	if (n.left != null) {
    		return getMaximum(n.left);
    	}
    	if (root == n) {
    		return null;
    	}
    	TreeNode p = null;
    	TreeNode cur = root;
    	while (cur != null) {
    		if (cur.val > n.val) {
    			cur = cur.left;
    		} else if (cur.val < n.val) {
    			p = cur;
    			cur = cur.right;
    		} else {
    			break;
    		}
    	}
    	return p;
    }

    private static TreeNode getSuccessor(TreeNode root, TreeNode n) {
    	if (n == null) return null;
    	if (n.right != null) {
    		return getMinimum(n.right);
    	}
    	if (root == n) {
    		return null;
    	}
    	TreeNode p = null;
    	TreeNode cur = root;
    	while (cur != null) {
    		if (cur.val > n.val) {
    			p = cur;
    			cur = cur.left;
    		} else if (cur.val < n.val) {
    			cur = cur.right;
    		} else {
    			break;
    		}
    	}
    	return p;
    }

    private static TreeNode getMinimum(TreeNode root) {
    	TreeNode p = root;
    	while (p.left != null) {
    		p = p.left;
    	}
    	return p;
    }

    private static TreeNode getMaximum(TreeNode root) {
    	TreeNode p = root;
    	while (p.right != null) {
    		p = p.right;
    	}
    	return p;
    }
}
