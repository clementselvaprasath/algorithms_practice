package algorithms.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author qz
 *
 */
public class TopKFrequentElements {

	// bucket sort
	public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] freq = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int f = map.get(n);
            if (freq[f] == null) {
                freq[f] = new ArrayList<>();
            }
            freq[f].add(n);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == null) continue;
            List<Integer> l = freq[i];
            if (l.size() <= k) {
                res.addAll(l);
                k -= l.size();
                if (k == 0) break;
            } else {
                res.addAll(l.subList(0, k));
                break;
            }
        }
        return res;
    }
	
	// priority queue. O(nlgn)
	public List<Integer> topKFrequent_nlgn(int[] nums, int k) {
        if (nums.length == 0) new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int n : map.keySet()) {
            q.offer(n);
            if (q.size() > k) q.poll();
        }
        
        return new ArrayList<>(q);
    }
}
