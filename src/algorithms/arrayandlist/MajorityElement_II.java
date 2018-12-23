package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * 
 * @author qz
 *
 */
public class MajorityElement_II {

	public static void main(String[] args) {

		MajorityElement_II ins = new MajorityElement_II();
		
		int[] nums = {6,7,7,7,7,7,6,6,6};
		System.out.println(ins.majorityElement(nums));
	}

	/**
	 * for majority elements which more than n/k, we will have at most k - 1 elements as candidate.
	 * we create an array with k - 1 size for tracking candidates, and an array with k - 1 for tracking
	 * appear times, when iterating the input array, we are doing the following:
	 * 1. if we find any candidate is the same as the nums[i], increase the count by 1 for that candidate
	 * 2. if the number of candidates we found are less than k - 1, we fill it first.
	 * 3. if we have found k - 1 candidates, and nums[i] is different from all candidates, we decrease the count of all candidates by 1
	 * 
	 * The basic idea is finding k - 1 different elements, and remove from the list.
	 */
	public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int k = 3, n = nums.length;
        
        int[] count = new int[k - 1];
        int[] candidates = new int[k - 1];
        
        for (int i = 0; i < n; i++) {
            boolean used = false;
            for (int j = 0; j < k - 1; j++) {
                if (candidates[j] == nums[i]) {
                    count[j]++;
                    used = true;
                    break;
                }
            }
            
            if (used) continue;
            for (int j = 0; j < k - 1; j++) {
                if (count[j] == 0) {
                    candidates[j] = nums[i];
                    count[j] = 1;
                    used = true;
                    break;
                }
            }
            
            if (used) continue;
            for (int j = 0; j < k - 1; j++) {
                count[j]--;
            }
        }

        Set<Integer> set = new HashSet<>();
        int[] verify = new int[k - 1];
        for (int j = 0; j < k - 1; j++) {
            for (int i = 0; i < n; i++) {
                if (candidates[j] == nums[i]) verify[j]++;
            }
            if (verify[j] > n / 3) set.add(candidates[j]);
        }

        return new ArrayList<>(set);
    }
	
}
