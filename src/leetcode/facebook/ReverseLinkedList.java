package leetcode.facebook;

import datastructure.ListNode;

/**
 * Reverse a singly linked list.
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * 
 * @author qz
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode res = reverseList_recursive(head);
		while (res != null) {
			System.out.print(res.val + "\t");
			res = res.next;
		}
	}
	
	public static ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseList(null, head);
    }
    
    public static ListNode reverseList(ListNode prev, ListNode head) {
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
        return reverseList(prev, head);
    }
	
	public ListNode reverseList_iterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cursor = head;
        ListNode prev = null;
        while (cursor != null) {
            ListNode tmp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = tmp;
        }
        
        return prev;
    }
}
