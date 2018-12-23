package leetcode.amazon;

import datastructure.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


 * @author qz
 *
 */
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);

        ListNode n1 = head, n2 = rev;
        while (n1 != null && n2 != null) {
        	if (n1.val != n2.val) return false;
        	n1 = n1.next;
        	n2 = n2.next;
        }

        return true;
    }

    private ListNode findMid(ListNode head) {
    	if (head == null) return null;
    	ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode cursor) {
    	if (cursor == null) return null;

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
