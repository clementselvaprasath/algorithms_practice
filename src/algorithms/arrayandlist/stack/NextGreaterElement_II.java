package algorithms.arrayandlist.stack;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number; The second
 * 1's next greater number needs to search circularly, which is also 2. Note:
 * The length of given array won't exceed 10000.
 * 
 * 
 * @author qz
 *
 */
public class NextGreaterElement_II {

	public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 0) return res;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            if (i < n) {
            	res[i] = -1;
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                int val = stack.pop();
                res[val] = nums[index];
            }
            stack.push(index);
        }
        
        return res;
    }
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "(702) 355-1937";
		System.out.println(URLEncoder.encode(s, "UTF-8"));
	}
}
