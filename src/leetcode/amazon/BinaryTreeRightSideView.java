package leetcode.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithms.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * 
 * @author qz
 *
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode n = q.poll();
        		if (i == size - 1) {
        			res.add(n.val);
        		}
        		if (n.left != null) q.offer(n.left);
        		if (n.right != null) q.offer(n.right);
        	}
        }

        return res;
    }
}
