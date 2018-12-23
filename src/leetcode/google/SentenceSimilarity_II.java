package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarity_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        UnionFind uf = new UnionFind();
        for (String[] strs : pairs) {
            uf.union(strs[0], strs[1]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (!uf.find(words1[i]).equals(uf.find(words2[i]))) return false;
        }
        
        return true;
    }

	class UnionFind {
	    Map<String, String> map;
	    
	    public UnionFind () {
	        map = new HashMap<>();
	    }
	    
	    public void union(String a, String b) {
	        String roota = find(a);
	        String rootb = find(b);
	        if (roota.equals(rootb)) return;
	        map.put(roota, rootb);
	    }
	    
	    public String find(String a) {
	        if (!map.containsKey(a)) {
	            map.put(a, a);
	            return a;
	        }
	        if (map.get(a).equals(a)) {
	            return a;
	        }
	        String s = find(map.get(a));
	        map.put(map.get(a), s);
	        return s;
	    }
	}
	
}

