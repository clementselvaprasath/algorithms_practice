package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".


 * @author qz
 *
 */
public class SimplifyPath {
	
	public String simplifyPath(String path) {
    	if (path == null || path.isEmpty()) return path;
    	StringBuilder sb = new StringBuilder();
    	sb.append("/");
    	String[] strs = path.split("/+");

    	List<String> list = new ArrayList<>();
    	for (String s : strs) {
    		if (s.equals("..")) {
    			if (!list.isEmpty()) list.remove(list.size() - 1);
    		} else if (!s.equals(".") && !s.equals("")) {
    			list.add(s);
    		}
    	}

    	for (String s : list) {
    		sb.append(s).append("/");
    	}
    	if (sb.length() > 1) {
    		return sb.substring(0, sb.length() - 1);
    	}
    	return sb.toString();
    }
}
