package leetcode.facebook;

import java.util.Stack;

import algorithms.Node;

public class BST2DLinkedList {

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		two.left = one;
		two.right = three;
		four.left = two;
		four.right = five;
		
		Node res = treeToDoublyList_iterative(four);
		System.out.println(res.val);
	}

	// iterative
	public static Node treeToDoublyList_iterative(Node root) {
        if (root == null) return root;
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node left = null;
        Node prev = null;
        //Node head = new Node();
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p.left = prev;
            if (prev != null) prev.right = p;
            if (left == null) left = p;
            prev = p;
            p = p.right;
        }
        left.left = prev;
        prev.right = left;
        //head.right = left;
        return left;
    }
	
	// recursive
	Node prev = null;
    Node leftMost = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inorder(root);
        leftMost.left = prev;
        prev.right = leftMost;
        return leftMost;
    }
    
    private void inorder(Node root) {
        if (root == null) return;
        
        inorder(root.left);
        if (leftMost == null) leftMost = root;
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        inorder(root.right);
    }
}
