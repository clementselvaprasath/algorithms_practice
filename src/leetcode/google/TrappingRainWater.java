package leetcode.google;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int i = 0, j = height.length - 1, k = 0, res = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                k = i + 1;
                while (k < j && height[k] < height[i]) {
                    res += height[i] - height[k];
                    k++;
                }
                i = k;
            } else {
                k = j - 1;
                while (k > i && height[k] < height[j]) {
                    res += height[j] - height[k];
                    k--;
                }
                j = k;
            }
        }

        return res;
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
