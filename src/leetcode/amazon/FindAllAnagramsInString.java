package leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 * @author qz
 *
 */
public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || p.length() > s.length()) return res;
        
        char[] chars = p.toCharArray();
        int[] count = new int[26];
        int p_len = chars.length, s_len = s.length(), match = 0;
        for (int i = 0; i < p_len; i++) {
            count[chars[i] - 'a']++;
        }
        
        for (int start = 0, end = 0; end < s_len; end++) {
            char c = s.charAt(end);
            if (count[c - 'a'] >= 1) match++;
            count[c - 'a']--;
            if (end - start + 1 > p_len) {
                char sc = s.charAt(start);
                if (count[sc - 'a'] >= 0) {
                    match--;
                }
                count[sc - 'a']++;
                start++;
            }
            if (match == p_len) {
                res.add(start);
            }
        }
        
        return res;
    }
}
