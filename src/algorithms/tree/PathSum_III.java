package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
	 */
	// i: tree level, j: sum
	// f[i][j] = f[i - 1][j] + f[i - 1][j - root.val]
	public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, false);
    }
    
    private int pathSum(TreeNode root, int sum, boolean partial) {
        if (root == null) return 0;
        int total = (root.val == sum? 1 : 0);
        total += pathSum(root.left, sum - root.val, true) + pathSum(root.right, sum - root.val, true);
        if (!partial) {
            total += pathSum(root.left, sum, false) + pathSum(root.right, sum, false);
        }
        return total;
    }
    
    // 5, 3, 6, 2, -3, target = 8
    // 5, 8, 14, 16, 13
    // count all valid path to current node
    public int pathSum_AnotherSolution(TreeNode root, int sum) {
    	if (root == null) return 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 1);
        return helper(root, 0, sum, map);
    }
    
    private int helper(TreeNode root, int curr, int sum, Map<Integer, Integer> map) {
    	if (root == null) return 0;

        curr += root.val;
        int total = map.getOrDefault(curr - sum, 0);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        total += helper(root.left, curr, sum, map) + helper(root.right, curr, sum, map);
        // backtracking here
        map.put(curr, map.getOrDefault(curr, 0) - 1);
        return total;
    }
}











