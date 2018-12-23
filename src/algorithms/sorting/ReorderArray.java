package algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Construct minimum number by reordering a given non-negative integer array. Arrange them such that they form the minimum number.

 Notice
The result may be very large, so you need to return a string instead of an integer.

Have you met this question in a real interview? Yes
Example
Given [3, 32, 321], there are 6 possible numbers can be constructed by reordering the array:

3+32+321=332321
3+321+32=332132
32+3+321=323321
32+321+3=323213
321+3+32=321332
321+32+3=321323
So after reordering, the minimum number is 321323, and return it.

Challenge 
Do it in O(nlogn) time complexity.


 * @author qz
 *
 */
public class ReorderArray {

	public static void main(String[] args) {
		int[] n = {0, 0};
		System.out.println(minNumber(n));
	}
	
	/**
	 * sort the  array as such (s1 + s2).compareTo(s2 + s1)
	 * check if the head digits of the result are "0"
	 * 
	 */
	public static String minNumber(int[] nums) {
		// write your code here
        if (nums == null || nums.length <= 1) return "" + nums[0];
        
        int n = nums.length;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        
        int k = 0;
        while (k < n && sb.charAt(k) == '0') {
            k++;
        }
        
        if (k == n) return "0";
        
        return sb.substring(k).toString();
    }
}
