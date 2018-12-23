package algorithms.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * 
 * @author qz
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<>();
    	if (n == 0) return res;

    	generate(n, n, "", res);
    	return res;
    }

    // left >= 0, apply "("
    // left < right, apply ")"
    private void generate(int left, int right, String path, List<String> res) {
    	if (left == right && left == 0) {
    		res.add(path);
    		return;
    	}

    	if (left >= 0) {
    		generate(left - 1, right, path + "(", res);
    	}

    	if (left < right) {
    		generate(left, right - 1, path + ")", res);
    	}
    }
}
