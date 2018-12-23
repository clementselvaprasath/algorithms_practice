package leetcode.apple;

import datastructure.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author qz
 *
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode n = new ListNode(0);
        ListNode c = n;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                c.next = l1;
                c = c.next;
                l1 = l1.next;
            } else {
                c.next = l2;
                c = c.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) c.next = l1;
        if (l2 != null) c.next = l2;
        
        return n.next;
    }
}
