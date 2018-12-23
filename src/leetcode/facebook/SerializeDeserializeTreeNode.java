package leetcode.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import algorithms.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 *  1
   / \
  2   3
     / \
    4   5
 * 
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself. Note: Do not use
 * class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 * 
 * @author qz
 *
 */
public class SerializeDeserializeTreeNode {

	public static void main(String[] args) {

	}

	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if (root == null) return null;
	        StringBuilder sb = new StringBuilder();
	        buildString(sb, root);
	        return sb.toString();
	    }

	    private void buildString(StringBuilder sb, TreeNode root) {
	        if (root == null) {
	            sb.append("#").append(",");
	        } else {
	            sb.append(root.val).append(",");
	            buildString(sb, root.left);
	            buildString(sb, root.right);
	        }
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        System.out.println(data);
	        if (data == null || data.isEmpty()) return null;
	        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
	        return buildTree(q);
	    }

	    private TreeNode buildTree(Queue<String> q) {
	        if(q.isEmpty()) return null;
	        String s = q.poll();
	        if ("#".equals(s)) return null;
	        else {
	            TreeNode n = new TreeNode(Integer.parseInt(s));
	            n.left = buildTree(q);
	            n.right = buildTree(q);
	            return n;
	        }
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
