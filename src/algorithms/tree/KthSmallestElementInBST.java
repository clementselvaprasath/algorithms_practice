package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * @author qz
 *
 */
public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> numOfNodes = new HashMap<>();
        countNodes(root, numOfNodes);
        return quickSelect(root, k, numOfNodes);
    }
    
    private int countNodes(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;

        int left = countNodes(root.left, map);
        int right = countNodes(root.right, map);
        map.put(root, left + 1);
        return left + right + 1;
    }
    
    private int quickSelect(TreeNode root, int k, Map<TreeNode, Integer> map) {
        if (root == null) return -1;
        
        int count = map.containsKey(root)? map.get(root) : 0;
        System.out.println("k=" + k + ", count=" + count);
        if (count == k) {
            return root.val;
        } else if (count > k) {
            return quickSelect(root.left, k, map);
        } else {
            return quickSelect(root.right, k - count, map);
        }
    }
}
