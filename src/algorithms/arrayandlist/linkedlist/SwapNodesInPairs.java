package algorithms.arrayandlist.linkedlist;

import datastructure.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. Note:
 * 
 * Your algorithm should use only constant extra space. You may not modify the
 * values in the list's nodes, only nodes itself may be changed.
 * 
 * @author qz
 *
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head;
        ListNode n = head.next;
        ListNode prev = null;
        head = head.next;
        while (p != null && p.next != null) {
        	p.next = n.next;
        	n.next = p;
        	if (prev != null) prev.next = n;
        	prev = p;
        	if (p != null && p.next != null) {
        		p = p.next;
        		n = p.next;
        	}
        }

        return head;
    }
}
