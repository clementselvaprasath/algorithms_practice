package leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one 0.
 * 
 * Example 1: Input: [1,0,1,1,0] Output: 4 Explanation: Flip the first zero will
 * get the the maximum number of consecutive 1s. After flipping, the maximum
 * number of consecutive 1s is 4. Note:
 * 
 * The input array will only contain 0 and 1. The length of input array is a
 * positive integer and will not exceed 10,000 Follow up: What if the input
 * numbers come in one by one as an infinite stream? In other words, you can't
 * store all numbers coming from the stream as it's too large to hold in memory.
 * Could you solve it efficiently?
 * 
 * @author qz
 *
 */
public class MaxConsecutiveOnesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// same idea as findMaxConsecutiveOnes_nothandlingdatastream(),
	// handling data stream model, use queue to keep track the zero indices
	public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, k = 1, max = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == 0) {
                q.offer(j);
            }
            while (q.size() > k) {
                i = q.poll() + 1;
            }
            max = Math.max(max, j - i + 1);
        }
        
        return max;
    }
	
	
	// keep track of left and right boundary, number of zeros
	// if the number of zeros exceed the allowed K value, we move left point to right until zero == K
	public int findMaxConsecutiveOnes_nothandlingdatastream(int[] nums) {
        int n = nums.length, k = 1, max = 0, zero = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[i++] == 0) zero--;
            }
            max = Math.max(max, j - i + 1);
        }
        
        return max;
    }
	
	public int findMaxConsecutiveOnes_firstTry(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, flip = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (flip == 0) {
                    left++;
                } else {
                    right++;
                }
            } else {
                if (flip == 1) {
                    max = Math.max(max, left + flip + right);
                    left = right;
                    right = 0;
                } else {
                    flip = 1;
                    if (i > 0 && nums[i - 1] == 0) {
                        left = 0;
                    }
                }
            }
        }

        return Math.max(max, left + flip + right);
    }
}
