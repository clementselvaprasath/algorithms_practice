package algorithms.sorting;

import java.util.Random;

public class QuickSelect {

	static Random rand = new Random();
	public static void main(String[] args) {
		int[] nums = {5, 3, 2, 5, 1, 8, 6, 5};

	}
	
	private static int quickSelect(int[] nums, int start, int end, int k) {
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        
        return nums[right + 1];
    }

	public static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;
        int pivot = A[index];
        int left = start;
        int right = end;
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left ++;
            }
            while (left <= right && A[right] > pivot) {
                right --;
            }
            
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left ++;
                right --;
            }
        }
        // A[start... right] 
        quickSort(A, start, right);
        // A[left ... end]
        quickSort(A, left, end);
    }
}
