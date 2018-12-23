package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * @author qz
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * postorder: the last one is the root
	 * inorder: range of left-subtree and right sub-tree
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(inorder[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
        	map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, len - 1, 0, len - 1, map);
    }

    private TreeNode build(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end, Map<Integer, Integer> map) {
    	if (in_start > in_end || post_start > post_end) return null;

    	int r = map.get(postorder[post_end]);
    	TreeNode root = new TreeNode(postorder[post_end]);
    	root.left = build(inorder, postorder, in_start, r - 1, post_start, post_start + r - in_start - 1, map);
    	root.right = build(inorder, postorder, r + 1, in_end, post_start + r - in_start, post_end - 1, map);
    	return root;
    }
}
