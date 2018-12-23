package algorithms.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = {5, 4, 1, 2, 3};
		int[] b = {10,9,2,5,3,7,101,18};
		/*
		 * [5, 4, 1, 2, 3]
		 * [1, 1, 1, 2, 3]
		 * 
		 * [4, 2, 5, 4, 3, 6, 5]
		 * [1, 1, 2, 2, 2, 3, 3]
		 * 
		 * 		[7, 8, 9, 2, 3, 8, 6]
		 * 		[1, 2, 3, 1, 2, 3, 3]
		 * [-inf,0, 1, 2,
		 * 
		 */
		
		System.out.println(lengthOfLIS(b));
		System.out.println(lengthOfLIS_Optimal_II(b));
	}

	/*
	 * Given a sequence of integers, find the longest increasing subsequence
	 * (LIS).
	 * 
	 * You code should return the length of the LIS.
	 * 
	 * Clarification What's the definition of longest increasing subsequence?
	 * 
	 * The longest increasing subsequence problem is to find a subsequence of a
	 * given sequence in which the subsequence's elements are in sorted order,
	 * lowest to highest, and in which the subsequence is as long as possible.
	 * This subsequence is not necessarily contiguous, or unique.
	 * 
	 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
	 * 
	 * Example For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3 For [4, 2, 4,
	 * 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
	 * 
	 * Challenge Time complexity O(n^2) or O(nlogn)
	 * 
	 */
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] f = new int[n];
        
        int max = 0;
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i] && f[j] < f[i] + 1) {
                    f[j] = f[i] + 1;
                }
            }
            max = Math.max(max, f[j]);
        }
        printArray(f);
        return max;
	}
	
	public static int lengthOfLIS_Optimal_II (int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] a = new int[n + 1];
		a[0] = Integer.MIN_VALUE;
		int top = 0;
		for (int i = 0; i < n; i++) {
			int start = 0, end = top, mid = 0, j = 0;
			while (start <= end) {
			    mid = start + (start - end) / 2;
			    if (a[mid] < nums[i]) {
			        j = mid;
			        start = mid + 1;
			    } else {
			        end = mid - 1;
			    }
			}
			a[j + 1] = nums[i];
			top = Math.max(top, j + 1);
		}
		printArray(a);
        return top;
	}
	
	/*
	 * O(nlgn)
	 * f(i): the number of elements that smaller than A[i]
	 * a(i): the smallest 
	 * 
	 */
	public static int lengthOfLIS_Optimal(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int n = nums.length;
		int[] f = new int[n];
		int[] a = new int[n + 1];
		a[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.MAX_VALUE;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			f[i] = findIndex(a, nums[i], max) + 1;
			max = Math.max(f[i], max);
			if (a[f[i]] > nums[i]) {
				a[f[i]] = nums[i];
			}
		}
		printArray(f);
		printArray(a);
		return max;
	}
	
	/**
	 * 
	 * @param a		array that stored the smallest element that with f[i] = k
	 * 				example: from nums[i] = 6, and we have found that f[i] = 4. Assume
	 * 				that we have a[4] = 7, which means for all f[k] = 4, k <= i, the index
	 * 				of smallest elements from nums is 7. If we found that nums[i] < nums[7],
	 * 				we will update a[4] = i so that we keep track of the smallest element
	 * 				with f[k] = 4
	 * @param f		f[i]: indicate that the longest increasing subsequence till i
	 * @param v		the value of current index
	 * @return		the longest length for K < v
	 */
	private static int findIndex (int[] a, int v, int top) {
		int start = 0, end = top, mid = 0;
		int max = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (a[mid] >= v) {
				end = mid - 1;
			} else {
				max = mid;
				start = mid + 1;
			}
		}
		
		return max;
	}
	
	private static void printArray (int[] a) {
		System.out.print("[ ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
}
