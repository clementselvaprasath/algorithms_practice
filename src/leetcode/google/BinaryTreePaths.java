package leetcode.google;

import java.util.ArrayList;
import java.util.List;

import algorithms.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	  Given a binary tree, return all root-to-leaf paths.
	  
	  Example
		Given the following binary tree:
		
		   1
		 /   \
		2     3
		 \
		  5
		All root-to-leaf paths are:
		
		[
		  "1->2->5",
		  "1->3"
		]
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		if (root == null) return new ArrayList<String>();
    	List<String> res = new ArrayList<String>();
    	binaryTreePaths(root, "" + root.val, res);
    	return res;
    }
	private static void binaryTreePaths(TreeNode root, String path, List<String> res) {
		if (root.left == null && root.right == null) {
			res.add(path);
			return;
		}
		if (root.left != null) {
			binaryTreePaths(root.left, path + "->" + root.left.val, res);
		}
		if (root.right != null) {
			binaryTreePaths(root.right, path + "->" + root.right.val, res);
		}
	}
}
