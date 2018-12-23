package leetcode.google;

import algorithms.TreeNode;

/**
 * Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Have you met this question in a real interview? Yes
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge 
Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)
 * @author qz
 *
 */
public class BSTIterator {
    TreeNode pre;
    TreeNode current;
    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        current = root;
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return current != null;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode res = null;
        while (current != null) {
        	if (current.left == null) {     // current has reached the left most node
            	res = current;              // find the required node
            	current = current.right;    // update current and break
            	break;
            } else {
            	pre = current.left;
            	while (pre.right != null && pre.right != current) {
            		pre = pre.right;
            	}
            	if (pre.right == null) {    // pre.right has not yet linked to its successor
            		pre.right = current;    // link to current
            		current = current.left; // update current and continue;
            	} else {
            		pre.right = null;       // pre.right = current, therefore, set it to null to restore the tree
    	        	res = current;          // find the required node.
    	        	current = current.right;    // update the current and break;
    	        	break;
            	}
            }
        }
        return res;
    }
}
