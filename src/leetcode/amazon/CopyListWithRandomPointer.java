package leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * @author qz
 *
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cursor = head;
        while (cursor != null) {
            map.put(cursor, new RandomListNode(cursor.label));
            cursor = cursor.next;
        }
        
        cursor = head;
        RandomListNode newHead = null;
        while (cursor != null) {
            if (newHead == null) {
                newHead = map.get(cursor);;
            } 
            
            newHead.next = map.get(cursor.next);
            newHead.random = map.get(cursor.random);
            newHead = newHead.next;
            cursor = cursor.next;
        }
        return map.get(head);
    }
	
    private class RandomListNode {
    	int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
