package leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author qz
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length < 3) return list;
        
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) break;
            int v = 0 - nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j >= k) break;
                if (nums[j] + nums[k] == v) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > v) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return list;
    }
}
