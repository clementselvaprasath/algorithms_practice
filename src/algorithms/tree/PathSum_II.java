package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }
        if (root.left != null) {
            List<List<Integer>> left = pathSum(root.left, sum - root.val);
            for (List<Integer> list : left) {
                list.add(0, root.val);
            }
            lists.addAll(left);
        }
        if (root.right != null) {
            List<List<Integer>> right = pathSum(root.right, sum - root.val);
            for (List<Integer> list : right) {
                list.add(0, root.val);
            }
            lists.addAll(right);
        }
        
        return lists;
    }
}
