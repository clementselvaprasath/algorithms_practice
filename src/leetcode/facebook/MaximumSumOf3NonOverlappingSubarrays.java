package leetcode.facebook;

import java.util.Arrays;

public class MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		int[] nums = {7,13,20,19,19,2,10,1,1,19};
		int k = 3;
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays_extensible(nums, k)));
	}
	
	public static int[] maxSumOfThreeSubarrays_extensible(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) s[i] = nums[i];
            else s[i] = s[i - 1] + nums[i];
        }
        
        int t = 3;
        int[][] f = new int[n][t + 1];
        int[][] id = new int[n][t + 1];
        for (int j = 1; j <= t; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = j * k - 1; i < n; i++) {
                f[i][j] = s[i];
                if (i >= k) f[i][j] += f[i - k][j - 1] - s[i - k];
                if (max < f[i][j]) {
                    max = f[i][j];
                    id[i][j] = i - k + 1;
                } else {
                    f[i][j] = max;
                    id[i][j] = id[i - 1][j];
                }
            }
        }
        
        int[] res = new int[t];
        int index = n - 1;
        for (int i = t; i >= 1; i--) {
            res[i - 1] = id[index][i]; 
            index = res[i - 1] - 1;
        }

        return res;
    }
	
	// find the sum W[i], W[j], W[k]
	// fix j, find the max of i from 0 ~ j - K, and the max of k from j + K ~ n - 1
	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] s = new int[n - k + 1];
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                for (int j = i; j < k; j++) {
                    s[i] += nums[j];
                }
            } else {
                s[i] = s[i - 1] + nums[i + k - 1] - nums[i - 1];
            }
        }
        
        int slen = s.length;
        int[] leftMax = new int[slen];
        int[] rightMax = new int[slen];

        for (int i = 0; i < slen; i++) {
            if (i == 0) leftMax[i] = i;
            else {
                if (s[i] > s[leftMax[i - 1]]) {
                    leftMax[i] = i;
                } else {
                    leftMax[i] = leftMax[i - 1];
                }
            }
        }
        for (int i = slen - 1; i >= 0; i--) {
            if (i == slen - 1) rightMax[i] = i;
            else {
                if (s[i] > s[rightMax[i + 1]]) {
                    rightMax[i] = i;
                } else {
                    rightMax[i] = rightMax[i + 1];
                }
            }
        }

        int[] res = new int[3];
        int max =  Integer.MIN_VALUE;
        for (int i = k; i < slen - k; i++) {
            if (s[i] + s[leftMax[i - k]] + s[rightMax[i + k]] > max) {
                max = s[i] + s[leftMax[i - k]] + s[rightMax[i + k]];
                res[0] = leftMax[i - k];
                res[1] = i;
                res[2] = rightMax[i + k];
            }
        }
        
        return res;
    }
}
