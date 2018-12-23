package algorithms.arrayandlist;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * 
 * Example Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * 
 * 
 * @author qz
 *
 */
public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates_shortAndClean(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }

	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 1) return nums.length;
        
        int i = 1, j = 0, current = 0, n = nums.length;
        for (i = 1; i < n; i++) {
            if (j >= n) break;
            if (nums[i] <= nums[current]) {
                j = i + 1;
                while (j < n && nums[j] <= nums[current]) {
                    j++;
                }
                if (j < n) {
                    swap (nums, i, j);
                    current = i;
                }
            } else {
                current++;
            }
        }
        
        return current + 1;
    }
    
    private void swap (int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}
