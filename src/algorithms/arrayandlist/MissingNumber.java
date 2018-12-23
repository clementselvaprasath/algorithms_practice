package algorithms.arrayandlist;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


 * @author qz
 *
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        for (int i : nums) {
        	sum -= i;
        }

        return sum;
    }
}
