package datastructure;

/**
 * http://www.lintcode.com/en/problem/interval-sum-ii/
 * @author qz
 *
 */
public class IntervalSum_II {
	/* you may need to use some attributes here */
	class SegmentTreeNode {
	    int start, end;
	    long sum;
	    SegmentTreeNode left, right;
	    public SegmentTreeNode(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.left = this.right = null;
	    }
	}
	    
    public SegmentTreeNode buildSegmentTree(int start, int end, int[] A) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = A[start];
            return node;
        }
        
        int mid = (start + end) / 2;
        node.left = buildSegmentTree(start, mid, A);
        node.right = buildSegmentTree(mid + 1, end, A);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    
    public long query(SegmentTreeNode root, int start, int end) {
        if (start > end) return Integer.MIN_VALUE;
        if (root.start == start && root.end == end) {
            return root.sum;
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
    
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }
	
    SegmentTreeNode root;
    /*
    * @param A: An integer array
    */
    public IntervalSum_II(int[] A) {
        // do intialization if necessary
        root = buildSegmentTree(0, A.length - 1, A);
    }
    
    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return query(root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        modify(root, index, value);
    }
}