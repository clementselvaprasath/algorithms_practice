package algorithms.tree;

public class PathSum {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        int res = sum - root.val;
        return hasPathSum(root.left, res) || hasPathSum(root.right, res);
    }
}
