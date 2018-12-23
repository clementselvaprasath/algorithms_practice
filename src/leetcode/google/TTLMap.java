package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a hashmap that accepts ttl value so that the entry will
 * be expired after ttl
 * 
 * @author qz
 *
 * @param <K>
 * @param <V>
 */
public class TTLMap<K, V> {

	Map<K, Node> map = new HashMap<>();
	Map<K, Long> ttlMap = new HashMap<>();
	Node head, tail;
	int size;

	public TTLMap(int size) {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		this.size = size;
	}

	/**
	 * update the val, reset the ttl
	 * 
	 * @param key
	 * @param val
	 * @param ttl
	 *            seconds
	 */
	public void put(K key, V val, int ttl) {
		// if reach the limit
		if (map.size() == size) {
			Node h = head.next;
			head.next = h.next;
			h.next.prev = head;
			map.remove(h.key);
			ttlMap.remove(h.key);
		}

		Node n = null;
		if (!map.containsKey(key)) {
			n = new Node(key, val);
		} else {
			n = map.get(key);
			n.val = val;
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}

		tail.prev.next = n;
		n.prev = tail.prev;
		n.next = tail;
		tail.prev = n;

		map.put(key, n);
		ttlMap.put(key, System.currentTimeMillis() + ttl * 1000);
	}

	/**
	 * if not expired, return the value if expired, remove the key, and return null
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		if (!map.containsKey(key))
			return null;

		long now = System.currentTimeMillis();
		if (now <= ttlMap.get(key)) {
			return map.get(key).val;
		}

		Node r = map.remove(key);
		ttlMap.remove(key);

		r.prev.next = r.next;
		r.next.prev = r.prev;

		return null;
	}

	private class Node {
		K key;
		V val;
		Node prev;
		Node next;

		public Node() {

		}

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TTLMap<Integer, Integer> map = new TTLMap<>(3);
		map.put(1, 1, 5);
		map.put(1, 2, 5);
		map.put(2, 3, 5);
		System.out.println("before limit: " + map.get(1));
		map.put(3, 1, 5);
		map.put(4, 6, 5);
		map.put(5, 0, 5);
		System.out.println("after limit: " + map.get(1));
		System.out.println("before sleep: " + map.get(4));
		Thread.sleep(5500);
		System.out.println("after sleep: " + map.get(4));
	}
}
