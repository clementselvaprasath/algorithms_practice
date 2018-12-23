package leetcode.google;

import algorithms.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 * 
 * @author qz
 *
 */
public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closestValue_clean(TreeNode root, double target) {
        if (Math.abs(target - root.val) < 1e-8) return root.val;
        
        int ans = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < 1e-8) return root.val;
            ans = Math.abs(target - root.val) < Math.abs(target - ans) ? root.val : ans;
            if (root.val < target) root = root.right;
            else root = root.left;
        }
        
        return ans;
    }
	
	public int closestValue(TreeNode root, double target) {
        if (Math.abs(target - root.val) < 1e-8) return root.val;
        
        TreeNode p = root;
        TreeNode smallestLarger = null;
        TreeNode largestSmaller = null;
        while (p != null) {
            if (Math.abs(target - p.val) < 1e-8) {
                return p.val;
            } else if (target > p.val) {
                largestSmaller = p;
                p = p.right;
            } else {
                smallestLarger = p;
                p = p.left;
            }
        }
        
        if (smallestLarger == null) {
            return largestSmaller.val;
        } else if (largestSmaller == null) {
            return smallestLarger.val;
        } else {
            return target - largestSmaller.val > smallestLarger.val - target? smallestLarger.val : largestSmaller.val;
        }
    }
}
