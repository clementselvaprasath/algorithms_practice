package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a text including words, and list of words that need to
 * be excluded.
 * Find out the most frequently used words from the text. Valid words must
 * not in the list of words to be excluded, and consisted by alphabetic only.
 * Results are case insensitive.
 * 
 * @author qz
 *
 */
public class MostFrequentlyUsedWords {

	public List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		// WRITE YOUR CODE HERE
		List<String> res = new ArrayList<>();
		if (literatureText == null || literatureText.isEmpty())
			return res;

		String context = literatureText.toLowerCase().replaceAll("\\W+", " ");
		String[] tokens = context.split("\\s+");

		int most = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String t : tokens) {
			if (!t.isEmpty() && isValid(t) && !wordsToExclude.contains(t)) {
				map.put(t, map.getOrDefault(t, 0) + 1);
				most = Math.max(most, map.get(t));
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == most) {
				res.add(entry.getKey());
			}
		}

		return res;
	}

	// METHOD SIGNATURE ENDS
	private static boolean isValid(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}
}
