package algorithms.arrayandlist.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * There are n cities on an axis, numbers from 0 ~ n - 1. John intends to do business in these n cities, He is interested in Armani's shipment. Each city has a price for these goods prices [i]. For city x, John can buy the goods from the city numbered from x - k to x + k, and sell them to city x. We want to know how much John can earn at most in each city?

 Notice
prices.length range is [2, 100000], k <= 100000.

Have you met this question in a real interview? Yes
Example
Given prices = [1, 3, 2, 1, 5], k = 2, return [0, 2, 1, 0, 4].

Explanation：
i = 0, John can go to the city 0 ~ 2. He can not make money because the prices in city 1 and city 2 are both higher than the price in city 0, that is, ans[0] = 0;
i = 1, John can go to the city 0~3. He can buy from city 0 or city 3 to earn the largest price difference. That is, ans[1] = 2.
i = 2, John can go to the city 0~4. Obviously, he can earn the largest price difference by buying from city 3. That is, ans[2] = 1.
i = 3, John can go to the city 1~4. He can not make money cause city 3 has the lowest price. That is, ans[3] = 0.
i = 4, John can go to the city 2~4. He can earn the largest price difference by buying from city 3. That is, ans[4] = 4.
Given prices = [1, 1, 1, 1, 1], k = 1, return [0, 0, 0, 0, 0]

Explanation:
All cities are the same price, so John can not make money, that is, all ans are 0.
 * @author qz
 *
 */
public class RegionalMinValue {

	public static void main(String[] args) {
		int[] n = {1,3,2,1,5,2,3,1,2,3,4,5,2,3,1,3};
		int k = 2;
		System.out.println(Arrays.toString(business_linear(n, k)));

	}

	public static int[] business(int[] A, int k) {
		int n = A.length;
        int[] res = new int[n];
        
        int window = 2 * k + 1;
        // value, number;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // index, value;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        while (j < k) {
            map.put(j, A[j]);
            treeMap.put(A[j], treeMap.getOrDefault(A[j], 0) + 1);
            j++;
        }
        
        for (int i = 0; i < n; i++) {
            if (i < n - k) {
                map.put(i + k, A[i + k]);
                treeMap.put(A[i + k], treeMap.getOrDefault(A[i + k], 0) + 1);
            }
            res[i] = A[i] - treeMap.firstKey();
            
            if ((map.size() >= window || i >= n - k) && i - k >= 0) {
                int value = map.get(i - k);
                int num = treeMap.get(value);
                if (num == 1) {
                    treeMap.remove(value);
                } else {
                    treeMap.put(value, num - 1);
                }
                map.remove(i - k);
            }
        }
        
        return res;
    }
	
	public static int[] business_linear(int[] A, int k) {
		int n = A.length;
        int[] res = new int[n];
        
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < k && j < n; j++) {
                    while (!deque.isEmpty() && A[j] < deque.peekLast()) {
                        deque.pollLast();  
                    }
                    deque.offer(A[j]);
                }
            }
            
            if (i + k < n) {
                while (!deque.isEmpty() && i + k < n && A[i + k] < deque.peekLast()) {
                    deque.pollLast();  
                }
                deque.offer(A[i + k]);
            }
            res[i] = A[i] - deque.peekFirst();
            if (i >= k) {
                if (A[i - k] == deque.peekFirst()) deque.pollFirst();
            }
        }
        
        return res;
    }
}
