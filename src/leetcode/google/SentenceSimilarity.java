package leetcode.google;

import java.util.HashSet;
import java.util.Set;

/**
 * 734. Sentence Similarity Given two sentences words1, words2 (each represented
 * as an array of strings), and a list of similar word pairs pairs, determine if
 * two sentences are similar.
 * 
 * For example, "great acting skills" and "fine drama talent" are similar, if
 * the similar word pairs are pairs = [["great", "fine"], ["acting","drama"],
 * ["skills","talent"]].
 * 
 * Note that the similarity relation is not transitive. For example, if "great"
 * and "fine" are similar, and "fine" and "good" are similar, "great" and "good"
 * are not necessarily similar.
 * 
 * However, similarity is symmetric. For example, "great" and "fine" being
 * similar is the same as "fine" and "great" being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences words1
 * = ["great"], words2 = ["great"], pairs = [] are similar, even though there
 * are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of words.
 * So a sentence like words1 = ["great"] can never be similar to words2 =
 * ["doubleplus","good"].
 * 
 * Note:
 * 
 * The length of words1 and words2 will not exceed 1000. The length of pairs
 * will not exceed 2000. The length of each pairs[i] will be 2. The length of
 * each words[i] and pairs[i][j] will be in the range [1, 20].
 * 
 * @author qz
 *
 */
public class SentenceSimilarity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Set<String> set = new HashSet<>();
        for (String[] strs : pairs) {
            set.add(strs[0] + strs[1]);
            set.add(strs[1] + strs[0]);
        }
        
        int n = words1.length;
        for (int i = 0; i < n; i++) {
            String s1 = words1[i], s2 = words2[i];
            if (!s1.equals(s2) && !set.contains(s1 + s2)) return false;
        }
        
        return true;
    }
}
