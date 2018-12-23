package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * @author qz
 *
 */
public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
        
        char[] chars = s.toCharArray();
        for (char c : chars) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] freq = new List[chars.length + 1];
        for (char c : map.keySet()) {
        	int f = map.get(c);
        	if (freq[f] == null) {
        		freq[f] = new ArrayList<>();
        	}
        	freq[f].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = freq.length - 1; i >= 1; i--) {
        	if (freq[i] == null) continue;
        	for (Character c : freq[i]) {
        		for (int j = 0; j < i; j++) {
        			sb.append(c);
        		}
        	}
        }

        return sb.toString();
    }
}
