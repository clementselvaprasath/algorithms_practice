package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
 * @author qz
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int i : map.values()) {
        	if (i % 2 == 1) count++;
        	if (count > 1) return false;
        }

        return true;
    }
}
