package algorithms.arrayandlist;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 * @author qz
 *
 */
public class ShuffleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    int[] origin;
	    Random rand;
	    public Solution(int[] nums) {
	        origin = Arrays.copyOf(nums, nums.length);
	        rand = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return origin;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int[] shuffle = Arrays.copyOf(origin, origin.length);
	        int j;
	        for (int i = shuffle.length - 1; i >= 0; i--) {
	            j = rand.nextInt(i + 1);
	            swap(shuffle, i, j);
	        }
	        
	        return shuffle;
	    }
	    
	    private void swap(int[] a, int i, int j) {
	        int tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	    }
	}

}
