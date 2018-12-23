package leetcode.apple;

import java.util.ArrayList;
import java.util.List;

import algorithms.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 * @author qz
 *
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        findPath(root, "" + root.val, res);
        return res;
    }
    
    private void findPath(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) findPath(root.left, path + "->" + root.left.val, res);
        if (root.right != null) findPath(root.right, path + "->" + root.right.val, res);
    }
}
