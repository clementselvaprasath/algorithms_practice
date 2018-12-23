package algorithms.binaryindextree;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 * @author qz
 *
 */
public class RangeSumQuery_Mutable {
	class NumArray {
	    int[] A, C;
	    int n;
	    public NumArray(int[] nums) {
	        n = nums.length;
	        C = new int[n + 1];
	        A = nums;
	        for (int i = 0; i < n; i++) {
	            add(i, A[i]);
	        }
	    }
	    
	    public void update(int i, int val) {
	        add(i, val - A[i]);
	        A[i] = val;
	    }
	    
	    public int sumRange(int i, int j) {
	        return sum(j) - sum(i - 1);
	    }
	    
	    private void add(int x, int val) {
	        x++;
	        for (int i = x; i <= n; i += lowbit(i)) {
	            C[i] += val;
	        }
	    }
	    
	    private int sum(int x) {
	        x++;
	        int res = 0;
	        for (int i = x; i > 0; i -= lowbit(i)) {
	            res += C[i];
	        }
	        
	        return res;
	    }
	    
	    private int lowbit(int i) {
	        return i & -i;
	    } 
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(i,val);
	 * int param_2 = obj.sumRange(i,j);
	 */
}
