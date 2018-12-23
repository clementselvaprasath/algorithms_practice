package leetcode.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithms.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target. Follow up: Assume
 * that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 * 
 * @author qz
 *
 */
public class ClosestBinarySearchTreeValue_II {

	public static void main(String[] args) {
		ClosestBinarySearchTreeValue_II ins = new ClosestBinarySearchTreeValue_II();
		TreeNode node3 = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		node3.left = node2;
		node3.right = node4;
		node2.left = node1;
		int k = 3;
		double t = 2.0;
		List<Integer> res = ins.closestKValues(node3, t, k);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		if (root == null)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();

		Stack<TreeNode> pred = new Stack<>();
		Stack<TreeNode> suc = new Stack<>();
		findPred(root, target, pred);
		findSuc(root, target, suc);

		while (k > 0) {
			k--;
			if (pred.empty()) {
				res.add(nextSuc(suc));
				continue;
			}
			if (suc.empty()) {
				res.add(nextPred(pred));
				continue;
			}
			int p = pred.peek().val, s = suc.peek().val;
			if (p == s)
				nextPred(pred);
			if (Math.abs(p - target) < Math.abs(s - target)) {
				res.add(nextPred(pred));
			} else {
				res.add(nextSuc(suc));
			}
		}

		return res;
	}

	private void findPred(TreeNode root, double target, Stack<TreeNode> pred) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == target) {
				pred.push(p);
				break;
			} else if (p.val < target) {
				pred.push(p);
				p = p.right;
			} else {
				p = p.left;
			}
		}
	}

	private void findSuc(TreeNode root, double target, Stack<TreeNode> suc) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == target) {
				suc.push(p);
				break;
			} else if (p.val < target) {
				p = p.right;
			} else {
				suc.push(p);
				p = p.left;
			}
		}
	}

	private int nextPred(Stack<TreeNode> pred) {
		TreeNode p = pred.pop();
		int res = p.val;
		p = p.left;
		while (p != null) {
			pred.push(p);
			p = p.right;
		}
		return res;
	}

	private int nextSuc(Stack<TreeNode> suc) {
		TreeNode p = suc.pop();
		int res = p.val;
		p = p.right;
		while (p != null) {
			suc.push(p);
			p = p.left;
		}
		return res;
	}
}
