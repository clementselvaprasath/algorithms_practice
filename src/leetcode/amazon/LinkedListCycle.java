package leetcode.amazon;

import datastructure.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 * @author qz
 *
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode cursor = head;
        ListNode runner = null;
        if (head.next != null) {
            runner = head.next.next;
        }
        while (cursor != null && runner != null) {
            if (cursor == runner) return true;
            cursor = cursor.next;
            if (runner.next == null) return false;
            runner = runner.next.next;
        }
        
        return false;
    }
}
