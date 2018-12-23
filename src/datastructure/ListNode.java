package datastructure;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode tail;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
		tail = this;
	}
	
	public ListNode addNode(int v) {
		ListNode n = new ListNode(v);
		next = n;
		return n;
	}
}
