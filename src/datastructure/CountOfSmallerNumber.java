package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumber {
	static class SegmentTreeNode {
	    int start, end, count;
	    SegmentTreeNode left, right;
	    public SegmentTreeNode() {
	        
	    }
	    
	    public SegmentTreeNode(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.left = this.right = null;
	        this.count = 0;
	    }
	    
	    public SegmentTreeNode build(int start, int end, int[] A) {
	        if (start > end) return null;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < A.length; i++) {
	            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
	        }
	        return build(start, end, map);
	    }
	    
	    private SegmentTreeNode build(int start, int end, Map<Integer, Integer> map) {
	        SegmentTreeNode node = new SegmentTreeNode(start, end);
	        if (start == end) {
	            if (map.containsKey(start)) {
	                node.count = map.get(start);
	            }
	            return node;
	        }
	        
	        int mid = (start + end) / 2;
	        node.left = build(start, mid, map);
	        node.right = build(mid + 1, end, map);
	        node.count = node.left.count + node.right.count;
	        return node;
	    }
	    
	    public int query(SegmentTreeNode root, int start, int end) {
	        if (root == null || start > end) return 0;
	        if (root.start >= start && root.end <= end) {
	            return root.count;
	        }
	        
	        int mid = (root.start + root.end) / 2;
	        if (end <= mid) {
	            return query(root.left, start, end);
	        } else if (start > mid) {
	            return query(root.right, start, end);
	        } else {
	            return query(root.left, start, mid) + query(root.right, mid + 1, end);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		int[] q = {1,2,3,4};
		List<Integer> res = countOfSmallerNumber(a, q);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}
    /*
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public static List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
    	// write your code here
        if (queries.length == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        SegmentTreeNode root = new SegmentTreeNode().build(0, 10000, A);
        for (int i = 0; i < queries.length; i++) {
            res.add(root.query(root, 0, queries[i] - 1));
        }
        
        return res;
    }
}