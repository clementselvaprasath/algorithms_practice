package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://lintcode.com/en/problem/flatten-list/
 * @author qz
 *
 */
public class FlattenList {
	public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if (nestedList == null || nestedList.isEmpty()) {
            return res;
        }
        
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        for (NestedInteger n : nestedList) {
            stack.push(n);
            while (!stack.empty()) {
                NestedInteger ni = stack.pop();
                if (ni.isInteger()) {
                    res.add(ni.getInteger());
                } else {
                    List<NestedInteger> l = ni.getList();
                    for (int i = l.size() - 1; i >= 0; i--) {
                        stack.push(l.get(i));
                    }
                }
            }
        }
        
        return res;
    }
}
