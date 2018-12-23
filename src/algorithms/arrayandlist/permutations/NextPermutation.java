package algorithms.arrayandlist.permutations;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 	1,2,3 → 1,3,2
 *	3,2,1 → 1,2,3
 *	1,1,5 → 1,5,1
 * 
 * @author qz
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        
        int p = nums.length - 1;
        while (p > 0 && nums[p] <= nums[p - 1]) {
        	p--;
        }
        swapRange(nums, p, nums.length - 1);
        if (p != 0) {
        	int q = p - 1;
        	while (p < nums.length && nums[q] >= nums[p]) {
        		p++;
        	}
        	swap(nums, p, q);
        }
    }

    private void swapRange(int[] nums, int start, int end) {
    	for (int i = start, j = end; i < j; i++, j--) {
    		swap(nums, i, j);
    	}
    }

    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
