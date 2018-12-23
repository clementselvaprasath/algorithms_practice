package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]`
 * 
 * @author qz
 *
 */
public class RestoreIPAddresses {

	/*
	 * consider cases like 0.0.0.0,
	 * 100.0.10.0
	 */
	public List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        findIPs(s, 0, 0, new StringBuilder(), res);

        return res;
    }

    private void findIPs(String s, int start, int dot, StringBuilder sb, List<String> res) {
    	if (dot == 3) {
    		if (start == s.length()) {
    			res.add(sb.toString());
    		}
    		return;
    	}

    	String tmp = "";
    	for (int i = start + 1; i <= s.length(); i++) {
    		tmp = s.substring(start, i);
    		if (!isValid(tmp, dot)) break;

    		if (sb.length() > 0 && dot < 3) {
    			sb.append(".");
    			dot++;
    		}
    		sb.append(tmp);
    		findIPs(s, i, dot, sb, res);
    		sb.delete(sb.length() - tmp.length(), sb.length());
    		if (dot > 0) {
    			sb.delete(sb.length() - 1, sb.length());
    			dot--;
    		}
    	}
    }

    private boolean isValid(String value, int dot) {
        if (value.charAt(0) == '0' && value.length() > 1) return false;
    	int v = Integer.parseInt(value);
    	return v >= 0 && v < 256;
    }
}
