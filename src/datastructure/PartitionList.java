package datastructure;

/**
 * http://lintcode.com/en/problem/partition-list/
 * 
 * @author qz
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		// write your code here
		if (head == null)
			return head;
		ListNode smaller = new ListNode(-1);
		ListNode s_cursor = smaller;
		ListNode greater = new ListNode(-1);
		ListNode g_cursor = greater;
		while (head != null) {
			if (head.val < x) {
				s_cursor.next = head;
				s_cursor = s_cursor.next;
			} else {
				g_cursor.next = head;
				g_cursor = g_cursor.next;
			}
			head = head.next;
		}

		g_cursor.next = null;
		s_cursor.next = greater.next;
		return smaller.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}