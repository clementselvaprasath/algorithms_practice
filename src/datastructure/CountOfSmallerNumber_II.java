package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/count-of-smaller-number-before-itself/
 * 
 * @author qz
 *
 */
public class CountOfSmallerNumber_II {
	static class SegmentTreeNode {
		int start, end, count;
	    SegmentTreeNode left, right;
	    public SegmentTreeNode(){}
	    public SegmentTreeNode(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.left = this.right = null;
	        this.count = 0;
	    }
	    
	    public SegmentTreeNode build(int start, int end) {
	        if (start > end) return null;
	        SegmentTreeNode node = new SegmentTreeNode(start, end);
	        if (start == end) {
	            return node;
	        }
	        int mid = (start + end) / 2;
	        node.left = build(start, mid);
	        node.right = build(mid + 1, end);
	        //node.count = node.left.count + node.right.count;
	        return node;
	    }
	    
	    public int query(SegmentTreeNode root, int start, int end) {
	        if (root == null || start > end) return 0;
	        if (start <= root.start && end >= root.end) return root.count;
	        int mid = (root.start + root.end) / 2;
	        if (start > mid) {
	            return query(root.right, start, end);
	        } else if (end <= mid) {
	            return query(root.left, start, end);
	        } else {
	            return query(root.left, start, mid) + query(root.right, mid + 1, end);
	        }
	    }
	    
	    public void modify(SegmentTreeNode root, int index, int value) {
	        if (root.start == index && root.end == index) {
	            root.count += value;
	            return;
	        }
	        int mid = (root.start + root.end) / 2;
	        if (mid >= index) {
	            modify(root.left, index, value);
	        } else {
	            modify(root.right, index, value);
	        }
	        
	        root.count = root.left.count + root.right.count;
	    }
	}
	
	public static void main(String[] args) {
		int[] A = {26,78,27,100,33,67,90,23,66,5,38,7,35,23};
		List<Integer> list = countOfSmallerNumberII(A);
		
		for (int i : list) {
			System.out.print(i + "\t");
		}
	}
	
	/*
	 * Give you an integer array (index from 0 to n-1, where n is the size of
	 * this array, data value from 0 to 10000) . For each element Ai in the
	 * array, count the number of element before this element Ai is smaller than
	 * it and return count number array.
	 * 
	 * Example For array [1,2,7,8,5], return [0,1,2,3,2]
	 */

	public static List<Integer> countOfSmallerNumberII(int[] A) {
		List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        
        int n = A.length;
        
        SegmentTreeNode segTree = new SegmentTreeNode().build(0, 10000);
        for (int i = 0; i < n; i++) {
            segTree.modify(segTree, A[i], 1);
            res.add(segTree.query(segTree, 0, A[i] - 1));
        }
        
        return res;
	}
}