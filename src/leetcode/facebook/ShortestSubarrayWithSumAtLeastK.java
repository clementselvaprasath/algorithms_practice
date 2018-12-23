package leetcode.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.

 

Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3
 

Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9

 * @author qz
 *
 */
public class ShortestSubarrayWithSumAtLeastK {

	public static void main(String[] args) {
		ShortestSubarrayWithSumAtLeastK obj = new ShortestSubarrayWithSumAtLeastK();
		int[] A = {56,-21,56,35,-9};
		int K = 61;
		System.out.println(obj.shortestSubarray(A, K));
	}
	
	public int shortestSubarray(int[] A, int K) {
        if (A.length == 0) return -1;
        
        int ans = Integer.MAX_VALUE, n = A.length;
        int[] S = new int[n + 1];
        for (int i = 0; i < n; i++) {
            S[i + 1] = S[i] + A[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!q.isEmpty() && S[i] - S[q.peekFirst()] >= K) {
                ans = Math.min(ans, i - q.pollFirst());
            }
            while (!q.isEmpty() && S[q.peekLast()] > S[i]) {
                q.pollLast();
            }
            q.offer(i);
        }
        
        return ans == Integer.MAX_VALUE? -1 : ans;
    }

}


/*
 * a,b,c,d,e,f,g,h,i
 * 
 * S[i] = sum(A[0]...A[i])
 * 
 */














