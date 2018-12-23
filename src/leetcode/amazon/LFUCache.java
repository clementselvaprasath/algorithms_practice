package leetcode.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. 
 * It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if 
the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already 
present. When the cache reaches its capacity, it should invalidate the 
least frequently used item before inserting a new item. For the purpose of 
this problem, when there is a tie (i.e., two or more keys that have the same 
frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache(2);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 * @author qz
 *
 */
public class LFUCache {
	int capacity;
	int lfu;
	Map<Integer, Node> value_map = new HashMap<>();
	Map<Integer, LinkedList<Node>> freq_list_map = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!value_map.containsKey(key)) return -1;
        Node res = value_map.get(key);

        int freq = res.freq;
        // remove from old freq list map    
        freq_list_map.get(freq).remove(res);
        if (freq_list_map.get(freq).isEmpty()) {
        	freq_list_map.remove(freq);
        	// update lfu val
        	if (freq == lfu) {
        		lfu++;
        	}
        }

        // update to new freq list
        if (!freq_list_map.containsKey(freq + 1)) {
        	freq_list_map.put(freq + 1, new LinkedList<>());
        }
		freq_list_map.get(freq + 1).add(res);

		res.freq += 1;

        return res.val;
    }
    
    public void put(int key, int value) {
    	if (capacity == 0) return;
        
		if (value_map.containsKey(key)) {
        	value_map.get(key).val = value;
        	get(key);
        	return;
    	}

        if (value_map.size() == capacity) {			
    		Node n = freq_list_map.get(lfu).pollFirst();
        	if (freq_list_map.get(lfu).isEmpty()) {
        		freq_list_map.remove(lfu);
        	}
        	value_map.remove(n.key);
        }

        lfu = 1;
        if (!freq_list_map.containsKey(lfu)) {
        	freq_list_map.put(lfu, new LinkedList<>());
        }
        Node nn = new Node(key, value, 1);
        freq_list_map.get(lfu).add(nn);
        value_map.put(key, nn);

    }

    private class Node {
    	int key;
    	int val;
    	int freq;
    	public Node (int key, int val, int freq) {
    		this.key = key;
    		this.val = val;
    		this.freq = freq;
    	}
    }
}
