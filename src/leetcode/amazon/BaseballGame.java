package leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

	public int calPoints(String[] ops) {
        if (ops.length == 0) return 0;
        int sum = 0;
        List<Integer> scores = new ArrayList<>();
        for (String s : ops) {
        	int val = 0;
        	if (isInteger(s)) {
        		val = Integer.parseInt(s);	
        	} else if ("+".equals(s)) {
        		val = 0;
        		for (int i = scores.size() - 1; i >= 0 && i >= scores.size() - 2; i--) {
        			val += scores.get(i);
        		}
        	} else if ("D".equals(s)) {
        		val = scores.get(scores.size() - 1) * 2;
        	} else if ("C".equals(s)) {
        		val = scores.get(scores.size() - 1) * -1;
        	}

        	if ("C".equals(s)) {
        		scores.remove(scores.size() - 1);
        	} else {
        		scores.add(val);
        	}
        	
        	sum += val;
        }

        return sum;
    }

    private boolean isInteger(String s) {
    	try {
    		int k = Integer.parseInt(s);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
}
