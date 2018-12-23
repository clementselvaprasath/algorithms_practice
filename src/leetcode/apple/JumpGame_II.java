package leetcode.apple;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * @author qz
 *
 */
public class JumpGame_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// greedy approach
	public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length;
        int count = 0, end = 0, rightMost = 0;
        for (int i = 0; i < n; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (rightMost >= n - 1) {
                count++;
                break;
            }
            if (i == end) {
                end = rightMost;
                count++;
            }
        }
        
        return count;
    }
}
