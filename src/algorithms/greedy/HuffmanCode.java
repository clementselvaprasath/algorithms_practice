package algorithms.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {

	public static void main(String[] args) {
		int[] A = {45, 13, 12, 16, 9, 5};
		TreeNode t = findMinimalCost(A);
		System.out.println(t.val);
	}

	/*
	 * Huffman Code: text compression
	 * given a set of characters and their frequencies A[1...n]
	 * Construct a tree T so that the total cost is minimal.
	 * Here, cost(T) = sum (A[i]*depth(C))
	 * 
	 */
	
	// apply greedy
	public static TreeNode findMinimalCost (int[] A) {
		if (A == null || A.length == 0) {
			return new TreeNode();
		}
		if (A.length == 1) {
			TreeNode t = new TreeNode();
			t.val = A[0];
			return t;
		}
		
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(new Comparator<TreeNode>(){
			public int compare (TreeNode t1, TreeNode t2) {
				return t1.val - t2.val;
			}
		});
		
		for (int a : A) {
			TreeNode t = new TreeNode();
			t.val = a;
			pq.add(t);
		}
		int n = A.length;
		
		for (int i = 0; i < n - 1; i++) {
			TreeNode z = new TreeNode();
			z.left = pq.poll();;
			z.right = pq.poll();
			z.val = z.left.val + z.right.val;
			pq.offer(z);
		}
		
		return pq.poll();
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	int freq;
}
