package algorithms.arrayandlist.linkedlist;

import datastructure.ListNode;

/**
 * http://lintcode.com/en/problem/reverse-linked-list/
 * 
 * Reverse a linked list.
 * 
 * Example For linked list 1->2->3, the reversed linked list is 3->2->1
 * 
 * Challenge Reverse it in-place and in one-pass
 * 
 * @author qz
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }

}
