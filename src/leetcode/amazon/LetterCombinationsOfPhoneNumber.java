package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	static final Map<Character, String[]> map = new HashMap<>();
    static {
        map.put('2',  new String[]{"a", "b", "c"});
        map.put('3',  new String[]{"d", "e", "f"});
        map.put('4',  new String[]{"g", "h", "i"});
        map.put('5',  new String[]{"j", "k", "l"});
        map.put('6',  new String[]{"m", "n", "o"});
        map.put('7',  new String[]{"p", "q", "r", "s"});
        map.put('8',  new String[]{"t", "u", "v"});
        map.put('9',  new String[]{"w", "x", "y", "z"});
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty() || !digits.matches("[2-9]+")) return res;
        build(digits.toCharArray(), 0, new StringBuilder(), res);
        return res;
    }
    
    private void build (char[] digits, int current, StringBuilder sb, List<String> res) {
        if (current == digits.length) {
            res.add(sb.toString());
            return;
        }
        
        String[] strs = map.get(digits[current]);
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            build(digits, current + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
