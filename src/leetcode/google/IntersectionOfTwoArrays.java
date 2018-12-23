package leetcode.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author qz
 *
 */
public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int v : resSet) {
            res[i++] = v;
        }

        return res;
    } 
}
