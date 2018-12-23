package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it.
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * 
	 * Follow up: What if the BST is modified (insert/delete operations) often
	 * and you need to find the kth smallest frequently? How would you optimize
	 * the kthSmallest routine?
	 */
	
	public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root, list);
        return list.get(k - 1);
    }
    
    private static void kthSmallest(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, list);
        list.add(root.val);
        kthSmallest(root.right, list);
    }
}
