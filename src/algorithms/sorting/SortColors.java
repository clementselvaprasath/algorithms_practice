package algorithms.sorting;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's. Could
 * you come up with a one-pass algorithm using only constant space?
 * 
 * 
 * @author qz
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
		int red = 0, blue = nums.length - 1;

		for (int i = 0; i <= blue; i++) {
			while (i >= red && i <= blue && (nums[i] == 0 || nums[i] == 2)) {
				if (nums[i] == 0) {
					swap(nums, i, red++);
				} else {
					swap(nums, i, blue--);
				}
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void sortColors_jiuzhang(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}

		int pl = 0;
		int pr = a.length - 1;
		int i = 0;
		while (i <= pr) {
			if (a[i] == 0) {
				swap(a, pl, i);
				pl++;
				i++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, pr, i);
				pr--;
			}
		}
	}
}
