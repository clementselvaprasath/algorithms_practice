package algorithms.arrayandlist.linkedlist;

import datastructure.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author qz
 *
 */
public class ReverseLinkedList_II {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) return head;
        if (m > n) return reverseBetween(head, n, m);

        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode prev = res, cursor = head, prev_node_m = res, tail = null;

        for (int i = 0; i < n; i++) {
        	if (i >= n) break;

        	if (i + 1 >= m && i < n) {
        		ListNode tmp = cursor;
        		cursor = cursor.next;
        		tmp.next = prev;
        		prev = tmp;
        		if (tail == null) tail = prev;
        	} else {
        		prev = prev.next;
        		cursor = cursor.next;
        		prev_node_m = prev;
        	}
        }
        prev_node_m.next = prev;
        tail.next = cursor;

		return res.next;
    }
}
