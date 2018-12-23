package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +, -, 
 * or * between the digits so they evaluate to the target value.

Example
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

 */
public class AddOperators {

	public static void main(String[] args) {
		String nums = "123";
		int T = 6;
		List<String> res = addOperators(nums, T);
		
		for (String str : res) {
			System.out.println(str);
		}
	}

	public static List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return results;
        }
        helper(results, "", num, target, 0, 0, 0);
        return results;
    }
    public static void helper(List<String> results, String path, String num, int target, int pos, long eval, long multed){
        if (pos == num.length() && target == eval){
            results.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(results, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(results, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                helper(results, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                helper(results, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
