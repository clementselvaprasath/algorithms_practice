package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

import datastructure.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * 0 / \ -3 9 / / -10 5
 * 
 * @author qz
 *
 */
public class ConvertSortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		Map<Integer, ListNode> map = new HashMap<>();
		ListNode cursor = head;
		int index = 0;
		while (cursor != null) {
			map.put(index++, cursor);
			cursor = cursor.next;
		}

		return build(0, index - 1, map);
	}

	private TreeNode build(int start, int end, Map<Integer, ListNode> map) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(map.get(start).val);

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(map.get(mid).val);
		root.left = build(start, mid - 1, map);
		root.right = build(mid + 1, end, map);
		return root;
	}

	public TreeNode sortedListToBST_twoPointers(ListNode head) {
		return getTreeConstructed(head, null);
	}

	public TreeNode getTreeConstructed(ListNode head, ListNode end) {
		if (head == end)
			return null;

		if (head.next == end) {
			TreeNode node = new TreeNode(head.val);
			return node;
		}

		ListNode slow = head, fast = head;
		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = getTreeConstructed(head, slow);
		root.right = getTreeConstructed(slow.next, end);

		return root;
	}
}
