package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UglyNumber {

	public static void main(String[] args) {
		int n = 12;
		int[] a = {2, 7, 13, 19};
		int[] b = {2, 3, 5};
		System.out.println(nthUglyNumber(n));
		System.out.println(nSuperUglyNumber(n, b));
	}

	/*
	 * Write a program to check whether a given number is an ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 6, 8 are ugly while 14 is not ugly since it includes
	 * another prime factor 7.
	 * 
	 * Note that 1 is typically treated as an ugly number.
	 * 
	 * 
	 */
	public static boolean isUgly(int num) {
		if (num <= 0)
			return false;
		if (num < 7)
			return true;

		while (num > 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * Write a program to find the n-th ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the
	 * first 10 ugly numbers.
	 * 
	 * Note that 1 is typically treated as an ugly number, and n does not exceed
	 * 1690.
	 */
	/*
	 * 2^a * 3^b * 5^c
	 */
	public static int nthUglyNumber(int n) {
		int [] f = new int[n];
        f[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int v2 = 2, v3 = 3, v5 = 5;
        for(int i = 1; i < n; i++) {
            int min = Math.min(Math.min(v2, v3), v5);
            f[i] = min;
            if (min == v2) {
                v2 = 2 * f[++i2];
            }
            if (min == v3) {
                v3 = 3 * f[++i3];
            }
            if (min == v5) {
                v5 = 5 * f[++i5];
            }
        }

        return f[n-1];
	}
	
	/*
	 * Write a program to find the nth super ugly number.
	 * 
	 * Super ugly numbers are positive numbers whose all prime factors are in
	 * the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13,
	 * 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly
	 * numbers given primes = [2, 7, 13, 19] of size 4.
	 * 
	 * Note: (1) 1 is a super ugly number for any given primes. (2) The given
	 * numbers in primes are in ascending order. (3) 0 < k ≤ 100, 0 < n ≤ 106, 0
	 * < primes[i] < 1000. (4) The nth super ugly number is guaranteed to fit in
	 * a 32-bit signed integer.
	 * 
	 * 
	 */
	public static int nSuperUglyNumber (int n, int[] primes) {
		PriorityQueue<UglyFactor> pq = new PriorityQueue<UglyFactor>(new Comparator<UglyFactor>(){
			public int compare (UglyFactor u1, UglyFactor u2) {
				return u1.v - u2.v;
			}
		});
		for (int p : primes) {
			pq.add(new UglyFactor(p, 0, p));
		}
		int[] f = new int[n];
		f[0] = 1;
		for (int i = 1; i < n; i++) {
			UglyFactor min = pq.poll();
			f[i] = min.v;
			min.i = min.i + 1;
		    min.v = min.f * f[min.i];
			pq.add(min);
		}
		
		return f[n - 1];
	}
}

class UglyFactor {
	int v;
	int i;
	int f;

	public UglyFactor () {}
	public UglyFactor (int v, int i, int f) {
		this.v = v;
		this.i = i;
		this.f = f;
	}
}