package algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.TreeNode;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 * 
 * @author qz
 *
 */
public class MostFrequentSubtreeSum {

	public static void main(String[] args) {
		System.out.println(2147483647);

	}

	Map<Integer, Integer> map = new HashMap<>();
    int most = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        find(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == most) {
                list.add(entry.getKey());
            }
        }
        int k = 0;
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[k++] = list.get(i);
        }
        return res;
    }
    private int find (TreeNode root) {
        if (root == null) return 0;
        int sum = find(root.left) + find(root.right) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        most = Math.max(most, map.get(sum));
        return sum;
    }
}
