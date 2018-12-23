package leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/facebook/5/round-1-phone-interview/270/
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays. The result can be in any order. Follow up: What if the given
 * array is already sorted? How would you optimize your algorithm? What if
 * nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * @author qz
 *
 */
public class IntersectionOfTwoArrays_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums1) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int n = map.get(nums2[i]);
                if (n == 0) {
                    map.remove(nums2[i]);
                } else {
                    list.add(nums2[i]);
                    map.put(nums2[i], n - 1);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
