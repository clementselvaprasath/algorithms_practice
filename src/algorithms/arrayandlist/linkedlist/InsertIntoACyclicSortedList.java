package algorithms.arrayandlist.linkedlist;

/**
 * Given a node from a cyclic linked list which is sorted in ascending order,
 * write a function to insert a value into the list such that it remains a
 * cyclic sorted list. The given node can be a reference to any single node in
 * the list, and may not be necessarily the smallest value in the cyclic list.
 * 
 * If there are multiple suitable places for insertion, you may choose any place
 * to insert the new value. After the insertion, the cyclic list should remain
 * sorted.
 * 
 * If the list is empty (i.e., given node is null), you should create a new
 * single cyclic list and return the reference to that single node. Otherwise,
 * you should return the original given node.
 * 
 * @author qz
 *
 */
public class InsertIntoACyclicSortedList {

	public Node insert(Node head, int insertVal) {
        if (head == null) {
        	Node n = new Node(insertVal, null);
        	n.next = n;
        	return n;
        }
  
        Node prev = head, cur = prev.next, max = prev, min = cur;
        while (cur != head && (prev.val > insertVal || cur.val < insertVal)) {
        	prev = cur;
        	cur = cur.next;
        	// update max and min
            if (prev.val >= cur.val) {
        		max = prev;
        		min = cur;
        	}
        }

        /* 
         * if the all nodes were visited and couldn't find a position which
         * left <= val <= right, then insert it between min and max.
         * the condition should be when cur == head (visited all)
         */
        if (cur == head && (insertVal <= min.val || insertVal >= max.val)) {
        	prev = max;
        	cur = min;
        }

        Node n = new Node(insertVal, cur);
        prev.next = n;
        return head;
    }
	
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _next) {
	        val = _val;
	        next = _next;
	    }
	};
}
