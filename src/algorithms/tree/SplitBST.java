package algorithms.tree;

/**
 * 776.Split BST Given a Binary Search Tree (BST) with root node root, and a
 * target value V, split the tree into two subtrees where one subtree has nodes
 * that are all smaller or equal to the target value, while the other subtree
 * has all nodes that are greater than the target value. It's not necessarily
 * the case that the tree contains a node with value V.
 * 
 * Additionally, most of the structure of the original tree should remain.
 * Formally, for any child C with parent P in the original tree, if they are
 * both in the same subtree after the split, then node C should still have the
 * parent P.
 * 
 * You should output the root TreeNode of both subtrees after splitting, in any
 * order.
 * 
 * Input: root = [4,2,6,1,3,5,7], V = 2 Output: [[2,1],[4,3,6,null,null,5,7]]
 * Explanation: Note that root, output[0], and output[1] are TreeNode objects,
 * not arrays.
 * 
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
 * 
 *        4
        /   \
      2      6
     / \    / \
    1   3  5   7

while the diagrams for the outputs are:

          4
        /   \
      3      6      and    2
            / \           /
           5   7         1
Note:

The size of the BST will not exceed 50.
The BST is always valid and each node's value is different.

 * 
 */
public class SplitBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * result[0]: tree that smaller or equal than V.
	 * result[1]: tree that greater than V.
	 * 
	 * in each recursion, we always return the result
	 * of the subtree which meet the requirement.
	 */
	public TreeNode[] splitBST_concise(TreeNode root, int V) {
        TreeNode[] result = new TreeNode[2];
        if (root == null) return result;
        if (root.val <= V) {
            result[0] = root;
            TreeNode[] rightSide = splitBST(root.right, V);
            root.right = rightSide[0];
            result[1] = rightSide[1];
        } else {
            result[1] = root;
            TreeNode[] leftSide = splitBST(root.left, V);
            root.left = leftSide[1];
            result[0] = leftSide[0];
        }
        return result;
    }

	/**
	 * case 1: V < root.val, then larger tree's root is the root. Start
	 * from root and keep going left child, the smaller tree's root is 
	 * the first tree node that its value smaller or equal to V. 
	 * Once found, start from smaller tree's root, find the greatest 
	 * the tree node which its value is smaller or equal to V.
	 * 
	 * case 2: V >= root.val, similar to case 1, we need to find the larger
	 * one.
	 * 
	 * @param root
	 * @param V
	 * @return
	 */
	public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[2];
        TreeNode[] res = new TreeNode[2];
        res[0] = root;
        if (V < root.val) {
            TreeNode prev = root;
            TreeNode smaller = root.left;
            while (smaller != null && smaller.val > V) {
                prev = smaller;
                smaller = smaller.left;
            }
            // update tree nodes;
            if (smaller != null) {
                TreeNode cursor = smaller;
                while (cursor.right != null && cursor.right.val <= V) {
                    cursor = cursor.right;
                }
                prev.left = cursor.right;
                cursor.right = null;
            }
            res[1] = smaller;
        } else {
            TreeNode prev = root;
            TreeNode larger = root.right;
            while (larger != null && larger.val <= V) {
                prev = larger;
                larger = larger.right;
            }
            // update tree nodes;
            if (larger != null) {
                TreeNode cursor = larger;
                while (cursor.left != null && cursor.left.val > V) {
                    cursor = cursor.left;
                }
                prev.right = cursor.left;
                cursor.left = null;
            }
            res[1] = larger;
        }
        
        return res;
    }
}
