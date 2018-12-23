package leetcode.facebook;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
