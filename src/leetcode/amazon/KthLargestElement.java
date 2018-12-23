package leetcode.amazon;

import java.util.Random;

public class KthLargestElement {

	public static void main(String[] args) {
		KthLargestElement kth = new KthLargestElement();
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(kth.findKthLargest(nums, k));
	}

	Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        int start = 0, end = n - 1, pos = -1, p = pos - start + 1;
        while (p != k) {
        	if (p > k) {
        		end = pos - 1;
        	} else if (p < k) {
        		start = pos + 1;
        		k = k - p;
        	} else {
        		break;
        	}
            pos = select(nums, start, end);
            p = pos - start + 1;
        }

        return nums[pos];
    }

    private int select(int[] nums, int start, int end) {
    	int p = random.nextInt(end - start + 1) + start;
    	swap(nums, p, end);
    	int res = start;
    	for (int i = start; i < end; i++) {
    		if (nums[i] > nums[end]) {
    			swap(nums, res++, i);
    		}
    	}
    	swap(nums, res, end);
    	return res;
    }
    
    public int findKthLargest_iterative(int[] nums, int k) {
        int n = nums.length;

        int low = 0, high = n - 1;
        while (low <= high) {
        	int index = low - 1;
        	for (int i = low; i < high; i++) {
        		if (nums[i] > nums[high]) {
        			swap(nums, i, ++index);
        		}
        	}
        	swap(nums, ++index, high);
        	if (index == k - 1) {
        		return nums[index];
        	} else if (index < k - 1) {
        		low = index + 1;
        	} else {
        		high = index - 1;
        	}
        }
        return -1;
    }


    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
