package leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 * 
 * @author qz
 *
 */
public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Map<Character, String> map = new HashMap<>();
    static {
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty() || digits.contains("0")) return res;
        char[] sc = digits.toCharArray();
        getCombinations(sc, "", 0, sc.length, res);
        return res;
    }
    
    private void getCombinations(char[] sc, String path, int index, int length, List<String> res) {
        if (index == length) {
            res.add(path);
            return;
        }
        String str = map.get(sc[index]);
        for (int i = 0; i < str.length(); i++) {
            getCombinations(sc, path + str.charAt(i), index + 1, length, res);
        }
    }
}
