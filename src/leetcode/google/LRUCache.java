package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author qz
 *
 */
public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node (int k, int v) {
            key = k;
            val = v;
        }
    }
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    Map<Integer, Node> map;
    int capacity;
    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {
        // do intialization if necessary
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node n = map.get(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        
        moveToTail(n);
        return n.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node n = new Node(key, value);
        moveToTail(n);
        map.put(key, n);
    }
    
    private void moveToTail(Node n) {
        // tail
        n.prev = tail.prev;
        tail.prev = n;
        n.prev.next = n;
        n.next = tail;
    }
}
