package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	public TreeNode () {}
	public TreeNode (int val) {
		this.val = val;
	}
	
	public static TreeNode buildTree(int[] a) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode r = new TreeNode(a[0]);
		q.add(r);
		int i = 1;
		int n = a.length;
		while (!q.isEmpty()) {
			TreeNode p = q.poll();
			if (i < n) {
				p.left = new TreeNode(a[i]);
				q.offer(p.left);
			}
			if(i + 1 < n) {
				p.right = new TreeNode(a[i + 1]);
				q.offer(p.right);
			}
			i += 2;
		}
		
		return r;
	}
}
