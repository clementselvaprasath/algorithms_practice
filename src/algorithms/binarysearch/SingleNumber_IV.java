package algorithms.binarysearch;

/**
 * Give an array, all the numbers appear twice except one number which appears
 * once and all the numbers which appear twice are next to each other. Find the
 * number which appears once.
 * 
 * Notice 1 <= nums.length < 10^4 In order to limit the time complexity of the
 * program, your program will run 10^5 times.
 * 
 * Example Given nums = [3,3,2,2,4,5,5], return 4.
 * 
 * Explanation: 4 appears only once. Given nums = [2,1,1,3,3], return 2.
 * 
 * Explanation: 2 appears only once.
 * 
 * @author qz
 *
 */
public class SingleNumber_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getSingleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if ((end - mid) % 2 == 1) {
                    end = mid - 1;
                } else {
                    start = mid + 2;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if ((mid - start) % 2 == 1) {
                    start = mid + 1;
                } else {
                    end = mid - 2;
                }
            } else {
                return nums[mid];
            }
        }
        
        return nums[start];
    }
}
