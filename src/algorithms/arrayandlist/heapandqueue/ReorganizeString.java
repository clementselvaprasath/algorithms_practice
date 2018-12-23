package algorithms.arrayandlist.heapandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba" Example 2:
 * 
 * Input: S = "aaab" Output: "" Note:
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * @author qz
 *
 */
public class ReorganizeString {

	public static void main(String[] args) {
		String str = "aaaabbbbbccd";
		System.out.println(reorganizeString(str));
	}

	/**
	 * use priority queue, sort the element in queue by the appear times in
	 * the string.
	 * poll two elements and update the appear time in the map accordingly
	 * 
	 * @param S
	 * @return
	 */
	public static String reorganizeString(String S) {
        if (S == null || S.length() <= 1) return S;
        char[] chars = S.toCharArray();
        // <K, V> = <Character, appears>
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char a = pq.poll();
            // pq has only one element
            if (pq.isEmpty()) {
                if (map.get(a) > 1) {
                    return "";
                }
                sb.append(a);
                return sb.toString();
            }
            // pq has more than one element
            char b = pq.poll();
            // update the map
            int numa = map.get(a);
            int numb = map.get(b);
            map.put(a, numa - numb);
            // after subtraction, the second polled element will be removed from the map
            if (map.get(a) == 0) {
                map.remove(a);
            } else {
                pq.offer(a);
            }
            map.remove(b);
            // append the  characters to the string builder
            for (int i = 0; i < numb; i++) {
                sb.append(a).append(b);
            }
        }
        
        return sb.toString();
    }
}
