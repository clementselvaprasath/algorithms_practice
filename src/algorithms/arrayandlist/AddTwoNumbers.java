package algorithms.arrayandlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		// dummy head node
		ListNode head = new ListNode(0);
		ListNode cursor = head;
		int f = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + f;
			cursor.next = new ListNode(sum % 10);
			f = sum / 10;
			cursor = cursor.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode n = null;
		if (l1 != null) {
			n = l1;
		} else {
			n = l2;
		}

		while (n != null) {
			int sum = n.val + f;
			cursor.next = new ListNode(sum % 10);
			f = sum / 10;
			cursor = cursor.next;
			n = n.next;
		}
		if (f != 0) {
			cursor.next = new ListNode(f);
		}

		return head.next;
	}
}
