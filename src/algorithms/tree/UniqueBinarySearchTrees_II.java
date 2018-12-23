package algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://lintcode.com/en/problem/unique-binary-search-trees-ii/
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

Have you met this question in a real interview? Yes
Example
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author qz
 *
 */
public class UniqueBinarySearchTrees_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees_II u = new UniqueBinarySearchTrees_II();
		List<TreeNode> res = u.generateTrees(2);
		System.out.println(res.size());
	}

	public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }
    
    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
    	if (start == end) {
    		res.add(new TreeNode(start));
    		return res;
    	}

    	
    	List<TreeNode> left = new ArrayList<>();
    	List<TreeNode> right = new ArrayList<>();
    	for (int i = start; i <= end; i++) {
    		left = buildTree(start, i - 1);
    		right = buildTree(i + 1, end);
    		for (TreeNode l : left) {
	    		for (TreeNode r : right) {
	    			TreeNode n = new TreeNode(i);
	    			n.left = l;
	    			n.right = r;
	    			res.add(n);
	    		}
	    	}
    	}

    	return res;
    }
	
}
