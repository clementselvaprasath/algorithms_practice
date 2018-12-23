package algorithms.tree;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
	 */
	public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }

    private int getSum(TreeNode root, int prefix) {
        if (root == null) return 0;
        int sum = prefix * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        return getSum(root.left, sum) + getSum(root.right, sum);
    }
	
}
