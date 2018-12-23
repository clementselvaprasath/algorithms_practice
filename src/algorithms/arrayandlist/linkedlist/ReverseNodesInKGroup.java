package algorithms.arrayandlist.linkedlist;

import java.util.ArrayList;
import java.util.List;

import datastructure.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed. 
 * 
 * @author qz
 *
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.addNode(2)
			.addNode(3)
			.addNode(4)
			.addNode(5)
			.addNode(6)
			.addNode(7);
		
		ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
		rk.printlnNodes(n);
		ListNode res = rk.reverseKGroup(n, 3);
		rk.printlnNodes(res);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
	    if (head == null || k <= 1) return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    head = dummy;

	    while (head != null) {
	    	head = reverseK(head, k);
	    }

        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
    	// find tail
    	ListNode tail = head;
    	for (int i = 0; i < k; i++) {
    		tail = tail.next;
    		if (tail == null) {
    			return tail;
    		}
    	}

    	// set pointers
    	ListNode prev = tail.next;
    	ListNode curr = head.next, nt = tail.next;
    	// reverse
    	while (curr != nt) {
    		ListNode tmp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = tmp;
    	}
    	// update pointers
    	ListNode nh = head.next;
    	head.next = tail;
    	return nh;
    }
    
    private void printlnNodes(ListNode ln) {
    	while (ln != null) {
    		System.out.print(ln.val + "->");
    		ln = ln.next;
    	}
    	System.out.println("null");
    }
}
