package datastructure;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 *  A:          a1 → a2
                   	   ↘
                     	c1 → c2 → c3
                   	  ↗            
	B:     b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 * @author qz
 *
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// X the length of shared nodes of list A and list B, A' and B' are the length of A and B before reaching intersection
	// first iteration: a moved A' steps + X steps, b moved B' steps + X steps
	// second iteration: a was assigned by headB and moved B' steps, b was assigned by headA and moved A' steps
	public ListNode getIntersectionNode_two_iteration(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        
        return a;
    }
	
	// create a cycle, and find the starting point of the cycle, then break it
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        // check if headB is in listA
        ListNode tailA = headA;
        while (tailA.next != null) {
            if (headB == tailA) return headB;
            tailA = tailA.next;
        }
        if (headB == tailA) return headB;
        
        // check if headA is in listB
        ListNode tailB = headB;
        while (tailB.next != null) {
            if (headA == tailB) return headA;
            tailB = tailB.next;
        }
        if (headA == tailB) return headA;
        tailB.next = headB;
        
        ListNode slower = headA;
        ListNode faster = headA;
        while (faster != null) {
            slower = slower.next;
            faster = faster.next;
            if (faster != null) {
                faster = faster.next;
            }
            if (slower == faster) break;
        }
        if (faster != null) {
            slower = headA;
            while (slower != faster) {
                slower = slower.next;
                faster = faster.next;
            }
            tailB.next = null;
            return slower;
        }
        tailB.next = null;
        return null;
    }
}
