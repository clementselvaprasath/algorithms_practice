package leetcode.amazon;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * @author qz
 *
 */
public class TrappingRainWater {

	public int trap(int[] height) {
        if (height.length <= 2) return 0;
        
        int max_index = 0, max = Integer.MIN_VALUE, len = height.length;
        for (int i = 0; i < len; i++) {
            if (max < height[i]) {
                max = height[i];
                max_index = i;
            }
        }
        
        int sum = 0, left = height[0], right = height[len - 1];
        for (int i = 1; i < max_index; i++) {
            if (left <= height[i]) {
                left = height[i];
            } else {
                sum += left - height[i];
            }
        }
        
        for (int i = len - 2; i > max_index; i--) {
            if (right <= height[i]) {
                right = height[i];
            } else {
                sum += right - height[i];
            }
        }
        
        return sum;
    }
	
	// one pass
	public int trap_lan(int[] height) {
		if (height.length <= 2) return 0;
		int i = 0;
		int j = height.length - 1;
		int total = 0;
		int minHeight = Math.min(height[i], height[j]);
		while (i < j) {
			minHeight = Math.max(minHeight, Math.min(height[i], height[j]));
			boolean left = height[i] <= height[j] ? true : false;
			if (left) {
				total += minHeight > height[i] ? minHeight - height[i] : 0;
				i++;
			} else {
				total += minHeight > height[j] ? minHeight - height[j] : 0;
				j--;
			}
		}
		return total;
	}
}
