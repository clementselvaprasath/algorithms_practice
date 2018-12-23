package algorithms.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon sells books, every book has books which are strongly associated with
 * it. Given ListA and ListB,indicates that ListA [i] is associated with ListB
 * [i] which represents the book and associated books. Output the largest set
 * associated with each other(output in any sort). You can assume that there is
 * only one of the largest set.
 * 
 * Notice The number of books does not exceed 5000. Have you met this question
 * in a real interview? Example Given ListA = ["abc","abc","abc"], ListB =
 * ["bcd","acd","def"], return["abc","acd","bcd","dfe"].
 * 
 * Explanation: abc is associated with bcd, acd, dfe, so the largest set is the
 * set of all books Given ListA = ["a","b","d","e","f"], ListB =
 * ["b","c","e","g","g"], return ["d","e","f","g"].
 * 
 * Explanation: The current set are [a, b, c] and [d, e, g, f], then the largest
 * set is [d, e, g, f]
 * 
 * @author qz
 *
 */
public class MaximumAssociationSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> maximumAssociationSet(String[] A, String[] B) {
        if (A.length == 0 || B.length == 0) return new ArrayList<>();
        UnionFind uf = new UnionFind(A, B);
        for (int i = 0; i < A.length; i++) {
            uf.insert(A[i], B[i]);
        }
        Map<String, List<String>> map = new HashMap<>();
        String maxString = "";
        int maxCount = 0;
        for (String key : uf.parent.keySet()) {
            String p = uf.find(key);
            if (!map.containsKey(p)) {
                List<String> list = new ArrayList<>();
                list.add(key);
                map.put(p, list);
            } else {
                map.get(p).add(key);
            }
            if (maxCount < map.get(p).size()) {
                maxCount = map.get(p).size();
                maxString = p;
            }
        }
        
        return map.get(maxString);
    }
	
	class UnionFind {
	    Map<String, String> parent;
	    
	    public UnionFind (String[] A, String[] B) {
	        parent = new HashMap<>();
	        for (int i = 0; i < A.length; i++) {
	            parent.put(A[i], A[i]);
	            parent.put(B[i], B[i]);
	        }
	    }
	    
	    public void insert (String a, String b) {
	        String root_a = find(a);
	        String root_b = find(b);
	        if (!root_a.equals(root_b)) {
	            parent.put(root_a, root_b);
	        }
	    }
	    
	    public String find (String a) {
	        if (a.equals(parent.get(a))) {
	            return a;
	        }
	        String par = find(parent.get(a));
	        parent.put(a, par);
	        return par;
	    }
	}
}
