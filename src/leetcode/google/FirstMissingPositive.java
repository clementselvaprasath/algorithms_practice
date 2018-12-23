package leetcode.google;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author qz
 *
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// move every integer i to position i - 1, and find the first inproper integer.
	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] != i + 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (ans == nums[i]) ans++;
            else return ans;
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
