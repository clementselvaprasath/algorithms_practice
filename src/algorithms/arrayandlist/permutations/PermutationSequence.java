package algorithms.arrayandlist.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n!
 * inclusive.
 * 
 * Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 * 
 * @author qz
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        int p = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
        	nums.add(i);
        	p *= i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	if (k == 0) {
        		for (int j = nums.size() - 1; j >= 0; j--) {
	    			sb.append(nums.get(j));
	    		}
	    		return sb.toString();
        	}
        	p = p / nums.size();
        	int pos = k / p;
        	k = k % p;
        	if (k == 0) {
        		pos--;
        	}
        	sb.append(nums.remove(pos));
        }

        return sb.toString();
    }
}
