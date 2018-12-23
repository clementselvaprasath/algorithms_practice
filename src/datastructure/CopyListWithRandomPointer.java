package datastructure;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        // <K, V>: <Old, New>
        Map<RandomListNode, RandomListNode> map = getNodesMap(head);
        for (RandomListNode on : map.keySet()) {
            RandomListNode nn = map.get(on);
            nn.next = map.get(on.next);
            nn.random = map.get(on.random);
        }
        
        return map.get(head);
    }
    
    private Map<RandomListNode, RandomListNode> getNodesMap(RandomListNode head) {
        RandomListNode cursor = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cursor != null) {
            map.put(cursor, new RandomListNode(cursor.label));
            cursor = cursor.next;
        }
        
        return map;
    }
    private class RandomListNode {
    	int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
