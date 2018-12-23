package leetcode.facebook;

import datastructure.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * 
 * @author qz
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n) and constant space
	public boolean isPalindrome_constantspace(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        
        ListNode rev = reverse_constant(slow);
        ListNode cursor = head;
        while (rev != null && cursor != null) {
            if (rev.val != cursor.val) return false;
            rev = rev.next;
            cursor = cursor.next;
        }
        
        return true;
    }
    
    private ListNode reverse_constant(ListNode head) {
        ListNode rev = null;
        ListNode cursor = head;
        while (cursor != null) {
            ListNode tmp = cursor.next;
            cursor.next = rev;
            rev = cursor;
            cursor = tmp;
        }
        
        return rev;
    }
	
	// O(n) time, O(n) space
	public boolean isPalindrome(ListNode head) {
        ListNode nlist = reverse(head);
        ListNode rev = nlist;
        ListNode cursor = head;
        while (rev != null && cursor != null) {
            if (rev.val != cursor.val) return false;
            rev = rev.next;
            cursor = cursor.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cursor = head;
        while (cursor != null) {
            ListNode n = new ListNode(cursor.val);
            n.next = newHead.next;
            newHead.next = n;
            cursor = cursor.next;
        }
        
        return newHead.next;
    }
}
