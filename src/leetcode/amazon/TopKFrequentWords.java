package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 * @author qz
 *
 */
public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(a) - map.get(b);
            } else {
                return b.compareTo(a);
            }
        });
        
        for (String str : map.keySet()) {
            pq.offer(str);
            if (pq.size() > k) pq.poll();
        }
        
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        
        return res;
    }
}
