package algorithms.arrayandlist.linkedlist;

import datastructure.ListNode;

/**
 * http://lintcode.com/en/problem/linked-list-cycle/
 * @author qz
 *
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next; 
            }
        }
        
        return fast != null;
    }
}
