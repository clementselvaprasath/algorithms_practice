package algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	/**
	 * binary tree: inorder traversal, recursive
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
    	if (root == null) return;

    	inorder(root.left, res);
    	res.add(root.val);
    	inorder(root.right, res);
    }
    
    /**
     * binary tree: inorder traversal, iterative
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while(n != null || !stack.isEmpty()) {
        	while (n != null) {
        		stack.push(n);
        		n = n.left;
        	}
        	n = stack.pop();
        	res.add(n.val);
        	n = n.right;
        }

        return res;
    }
    
    /**
     * binary tree: preorder traversal, recursive
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
    	if (root == null) {
    		return;
    	}

    	res.add(root.val);
    	preorder(root.left, res);
    	preorder(root.right, res);
    }
	
    /**
     * binary tree: preorder traversal, iterative
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n != null || !stack.isEmpty()) {
        	while (n != null) {
        		stack.push(n);
        		res.add(n.val);
        		n = n.left;
        	}
        	n = stack.pop();
        	n = n.right;
        }

        return res;
    }
	
    /**
     * binary tree: postorder traversal, recursive
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
    	if (root == null) return;

    	postorder(root.left, res);
    	postorder(root.right, res);
    	res.add(root.val);
    }
    
    /**
     * binary tree: postorder traversal, iterative
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root, visited = null;
        while (n != null || !stack.isEmpty()) {
        	while (n != null) {
        		stack.push(n);
        		n = n.left;
        	}
        	n = stack.peek();
        	if (n.right != null && n.right != visited) {
        		n = n.right;
        	} else {
        		res.add(n.val);
        		visited = stack.pop();
        		n = null;
        	}
        }

        return res;
    }
    
    /**
     * binary tree: postorder traversal, iterative
     * reverse the preorder traversal, and then reverse the result
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_iterative2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n != null || !stack.isEmpty()) {
        	while (n != null) {
        		stack.push(n);
        		res.add(n.val);
        		n = n.right;
        	}
        	n = stack.pop();
        	n = n.left;
        }

        Collections.reverse(res);

        return res;
    }
}
