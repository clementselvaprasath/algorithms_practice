package leetcode.facebook;

import java.util.Stack;

import algorithms.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author qz
 *
 */
public class BSTIterator {

	TreeNode suc;
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        suc = null;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        suc = stack.pop();
        TreeNode p = suc.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return suc.val;
    }
}
