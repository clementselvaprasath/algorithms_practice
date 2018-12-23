package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

import algorithms.TreeNode;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author qz
 *
 */
public class UniqueBinarySearchTrees_II {
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
    	List<TreeNode> trees = new ArrayList<>();
    	if (start > end) {
    		trees.add(null);
    		return trees;
    	}
    	if (start == end) {
    		trees.add(new TreeNode(start));
    		return trees;
    	}

    	for (int i = start; i <= end; i++) {
    		List<TreeNode> left = buildTrees(start, i - 1);
    		List<TreeNode> right = buildTrees(i + 1, end);
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode t = new TreeNode(i);
    				t.left = l;
    				t.right = r;
    				trees.add(t);
    			}
    		}
    	}
    	return trees;
    }
}
