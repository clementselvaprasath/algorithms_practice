package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Write a program to find the nth super ugly number.
	 * 
	 * Super ugly numbers are positive numbers whose all prime factors are in
	 * the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13,
	 * 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly
	 * numbers given primes = [2, 7, 13, 19] of size 4.
	 * 
	 * Notice 1 is a super ugly number for any given primes. The given numbers
	 * in primes are in ascending order. 0 < k ≤ 100, 0 < n ≤ 10^6, 0 <
	 * primes[i] < 1000
	 * 
	 * Example Given n = 6, primes = [2, 7, 13, 19] return 13
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (primes == null || n == 0) return 0;

        PriorityQueue<UglyNumber> pq = new PriorityQueue<>(new Comparator<UglyNumber>(){
        	public int compare(UglyNumber u1, UglyNumber u2) {
        		return u1.val - u2.val;
        	}
        });
        for (int i : primes) {
        	pq.offer(new UglyNumber(i, 0, i));
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
        	UglyNumber un = pq.poll();
        	while (!pq.isEmpty() && un.val == pq.peek().val) {
        		UglyNumber tmp = pq.poll();
        		tmp.index += 1;
        		tmp.val = tmp.factor * res[tmp.index];
        		pq.offer(tmp);
        	}
        	res[i] = un.val;
        	un.index += 1;
        	un.val = un.factor * res[un.index];
        	pq.offer(un);
        }

        System.out.println(Arrays.toString(res));
        return res[n - 1];
	}
	
	public int nthSuperUglyNumber_WithoutClass(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] uglys = new int[n];
        uglys[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglys[times[j]]);
            }
            uglys[i] = min;

            for (int j = 0; j < times.length; j++) {
                if (uglys[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return uglys[n - 1];
    }
}

class UglyNumber {
	int factor;
	int index;
	int val;
	public UglyNumber(int factor, int index, int val) {
		this.factor = factor;
		this.index = index;
		this.val = val;
	}
}
