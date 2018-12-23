package leetcode.amazon;

import datastructure.ListNode;

/**
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author qz
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode cursor = head;
        ListNode prev = null;
        
        while (cursor != null) {
            ListNode tmp = cursor;
            cursor = cursor.next;
            tmp.next = prev;
            prev = tmp;
        }
        
        return prev;
    }
}
