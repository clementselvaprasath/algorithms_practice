package algorithms.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 * @author qz
 *
 */
public class BinaryTreeLevelOrderTraversal_II {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
        	List<TreeNode> list = new ArrayList<>();
        	List<Integer> level = new ArrayList<>();
        	while (!deque.isEmpty()) {
        		TreeNode n = deque.poll();
        		level.add(n.val);
        		if (n.left != null) list.add(n.left);
        		if (n.right != null) list.add(n.right);
        	}
        	deque.addAll(list);
        	res.add(level);
        }

        Collections.reverse(res);

        return res;
    }
}
