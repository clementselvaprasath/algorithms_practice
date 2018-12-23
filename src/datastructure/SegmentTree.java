package datastructure;

public class SegmentTree {

	private class SegmentTreeNode {
		int start, end, max;
		SegmentTreeNode left, right;
		
		public SegmentTreeNode (int start, int end) {
			this.start = start;
			this.end = end;
			this.left = this.right = null;
		}
		
		public SegmentTreeNode (int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
			this.left = this.right = null;
		}
	}
	
	public SegmentTreeNode build(int start, int end) {
		// write your code here
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            return node;
        }
        node.left = build(start, (start + end) / 2);
        node.right = build((start + end) / 2 + 1, end);
        
        return node;
	}
	
	public SegmentTreeNode build(int start, int end, int[] nums) {
		// write your code here
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
        	node.max = nums[start];
            return node;
        }
        node.left = build(start, (start + end) / 2, nums);
        node.right = build((start + end) / 2 + 1, end, nums);
        node.max = Math.max(node.left.max, node.right.max);
        return node;
	}
	
	public int query(SegmentTreeNode root, int start, int end) {
        if (root.start >= start && root.end >= end) return root.max;
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
        	return query(root.left, start, end);
        } else if (start > mid) {
        	return query(root.right, start, end);
        } else {
        	return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
        }
	}
	
	public void modify(SegmentTreeNode root, int index, int value) {
		if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        
        if (index <= (root.start + root.end) / 2) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
	}
	
	public static void main(String[] args) {
		int[] A = {26,78,27,100,33,67,90,23,66,5,38,7,35,23};
		SegmentTree tree = new SegmentTree();
		SegmentTreeNode segNode = tree.build(0, A.length - 1, A);
		System.out.println(tree.query(segNode, 5, 9));
	}

}
