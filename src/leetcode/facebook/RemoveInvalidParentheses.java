package leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 * @author qz
 *
 */
public class RemoveInvalidParentheses {

	/**
	 * Logical Thinking
We are required to return the minimum number of invalid parentheses to remove, 
that is, the shortest distance from s to a valid string. Shortest-path problem is natural to BFS.

As for BFS,
state node
current string
start state
s
end state
a valid string formed by removing parentheses from s

Trick

We mark a node visited as soon as we add it to queue in BFS.
To check whether a string is a valid parenthese combination, we maintain a variable stack to simulate the real Stack.
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses_bfs(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
        	return Arrays.asList("");
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String t = q.poll();
        		if (isValid(t)) {
        			res.add(t);
        		} else {
        			for (int j = 0; j < t.length(); j++) {
        				char c = t.charAt(j);
        				if (c == ')' || c == '(') {
        					String ns = t.substring(0, j) + t.substring(j + 1);
        					if (!visited.contains(ns)) {
        						visited.add(ns);
        						q.offer(ns);
        					}
        				}
        			}
        		}
        	}
        	if (!res.isEmpty()) break;
        }

        return res;
    }

    private boolean isValid(String s) {
    	int left = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == '(') {
    			left++;
    		}
    		if (c == ')') {
    			if (left == 0) {
    				return false;
    			} else {
    				left--;
    			}
    		}
    	}
    	return left == 0;
    }
}
