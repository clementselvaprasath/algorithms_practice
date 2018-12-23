package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 * @author qz
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * From inorder sequence, we can get the range of left sub-tree and right sub-tree.
	 * From preorder sequence, we can know the root node.
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int len = preorder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(preorder[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
        	map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, len - 1, 0, len - 1, map);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end, Map<Integer, Integer> map) {
    	if (pre_start > pre_end || in_start > in_end) return null;

    	int r = map.get(preorder[pre_start]);

    	TreeNode root = new TreeNode(preorder[pre_start]);
    	int off = r - in_start;
    	root.left = build(preorder, inorder, pre_start + 1, pre_start + off, in_start, r - 1, map);
    	root.right = build(preorder, inorder, pre_start + off + 1, pre_end, r + 1, in_end, map);
    	return root;
    }
}
