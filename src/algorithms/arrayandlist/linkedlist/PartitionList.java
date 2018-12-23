package algorithms.arrayandlist.linkedlist;

import datastructure.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 * 
 * @author qz
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode cursor = head;
        ListNode s = new ListNode(-1);
        ListNode ge = new ListNode(x);

        ListNode s_cur = s;
        ListNode ge_cur = ge;
        while (cursor != null) {
        	if (cursor.val < x) {
        		s_cur.next = cursor;
        		s_cur = s_cur.next;
        	} else {
        		ge_cur.next = cursor;
        		ge_cur = ge_cur.next;
        	}
        	cursor = cursor.next;
        }
        ge_cur.next = null;
        s_cur.next = ge.next;;
        return s.next;
    }
}
