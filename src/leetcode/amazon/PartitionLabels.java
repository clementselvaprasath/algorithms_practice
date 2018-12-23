package leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * Example 1: Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so
 * that each letter appears in at most one part. A partition like
 * "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less
 * parts. Note:
 * 
 * S will have length in range [1, 500]. S will consist of lowercase letters
 * ('a' to 'z') only.
 * 
 * @author qz
 *
 */
public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.isEmpty()) return res;
       
        char[] chars = S.toCharArray();
        int m = chars.length;
 		
        int[] ends = new int[26];
        for (int i = 0; i < m; i++) {
        	ends[chars[i] - 'a'] = i;
        }

        int start = 0, endMax = ends[chars[0] - 'a'];
        for (int i = 1; i < m; i++) {
        	int end = ends[chars[i] - 'a'];
        	if (i > endMax) {
        		res.add(endMax - start + 1);
        		start = i;
        		endMax = end;
        	} else {
        		endMax = Math.max(endMax, end);
        	}
        }

        res.add(endMax - start + 1);
        
        return res;
    }
}
