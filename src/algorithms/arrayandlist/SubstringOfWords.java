package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodstudentgoodword", words = ["word","student"] Output: []
 * 
 * @author qz
 *
 */
public class SubstringOfWords {

	public List<Integer> findSubstring_accepted(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.isEmpty() || words == null || words.length == 0)
			return res;

		int m = words.length, n = words[0].length();
		if (s.length() < m * n)
			return res;

		Map<String, Integer> toFind = new HashMap<>();
		Map<String, Integer> found = new HashMap<>();

		for (String word : words) {
			toFind.put(word, toFind.getOrDefault(word, 0) + 1);
		}

		for (int i = 0; i < s.length() - m * n + 1; i++) {
			found.clear();
			int j;
			for (j = 0; j < m; j++) {
				String sub = s.substring(i + j * n, i + j * n + n);
				if (!toFind.containsKey(sub))
					break;
				found.put(sub, found.getOrDefault(sub, 0) + 1);
				if (found.get(sub) > toFind.get(sub))
					break;
			}
			if (j == m)
				res.add(i);
		}

		return res;
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> pos = new ArrayList<>();

		if (s == null || words == null || s.length() == 0 || words.length == 0) {
			return pos;
		}
		HashMap<String, Integer> needToFind = new HashMap<>();
		int len = words[0].length();
		int wordsLen = words.length * len;

		if (s.length() < wordsLen) {
			return pos;
		}

		for (String word : words) {
			if (needToFind.containsKey(word)) {
				needToFind.put(word, needToFind.get(word) + 1);
			} else {
				needToFind.put(word, 1);
			}
		}

		for (int i = 0; i < len; i++) { // Maximum starting can be till len;

			HashMap<String, Integer> hasFound = new HashMap<>();
			int count = 0;
			int start = i;
			for (int end = i; end <= s.length() - len; end += len) {

				String current = s.substring(end, end + len);

				if (!needToFind.containsKey(current)) {
					hasFound.clear();
					// move start pointer
					start = end + len;
					count = 0;
				} else {
					if (!hasFound.containsKey(current)) {
						hasFound.put(current, 1);
					} else {
						hasFound.put(current, hasFound.get(current) + 1);
					}

					count += len;

					/*
					 * For example: "barfoofoobarthefoobarman"
					 * ["bar","foo","the"]
					 */
					while (hasFound.get(current) > needToFind.get(current)) {
						String left = s.substring(start, start + len);
						hasFound.put(left, hasFound.get(left) - 1);

						count -= len;
						start = start + len;
					}

					if (count == wordsLen) {
						pos.add(start);
						String left = s.substring(start, start + len);
						hasFound.put(left, hasFound.get(left) - 1);
						count -= len;
						start = start + len;
					}
				}

			}

		}

		return pos;
	}
}
