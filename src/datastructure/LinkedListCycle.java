package datastructure;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author qz
 *
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode faster = head.next;
        ListNode slower = head;
        while (faster != null) {
            if (slower == faster) return true;
            slower = slower.next;
            faster = faster.next;
            if (faster != null) {
                faster = faster.next;
            }
        }
        
        return false;
    }
}
