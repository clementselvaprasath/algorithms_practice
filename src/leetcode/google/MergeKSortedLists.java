package leetcode.google;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Merge k sorted linked lists and return it as one sorted list.
	 * 
	 * Analyze and describe its complexity.
	 * 
	 * Example Given lists:
	 * 
	 * [ 2->4->null, null, -1->null ], return -1->2->4->null.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() < 1)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
		for (ListNode node : lists) {
			if (node != null)
				pq.offer(node);
		}

		ListNode root = null;
		ListNode res = null;
		while (!pq.isEmpty()) {
			ListNode n = pq.poll();
			if (res == null) {
				root = new ListNode(n.val);
				res = root;
			} else {
				res.next = new ListNode(n.val);
				res = res.next;
			}
			if (n.next != null) {
				pq.offer(n.next);
			}
		}

		return root;
	}
	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

}
