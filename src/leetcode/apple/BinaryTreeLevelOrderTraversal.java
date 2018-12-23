package leetcode.apple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithms.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author qz
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.poll();
                list.add(n.val);
                if (n.left != null) tmp.add(n.left);
                if (n.right != null) tmp.add(n.right);
            }
            res.add(list);
            q.addAll(tmp);
        }
        return res;
    }
}
