package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 765. Couples Holding Hands
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want
 * to know the minimum number of swaps so that every couple is sitting side by
 * side. A swap consists of choosing any two people, then they stand up and
 * switch seats.
 * 
 * The people and seats are represented by an integer from 0 to 2N-1, the
 * couples are numbered in order, the first couple being (0, 1), the second
 * couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * 
 * The couples' initial seating is given by row[i] being the value of the person
 * who is initially sitting in the i-th seat.
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.
 * 
 * @author qz
 *
 */
public class CouplesHoldingHands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = row.length;
        for (int i = 0; i < n; i++) {
            map.put(row[i], i);
        }
        
        int count = 0;
        for (int i = 1; i < n; i += 2) {
            int now = row[i];
            int prev = row[i - 1];
            if (prev % 2 == 0 && prev == now - 1 || prev % 2 == 1 && prev == now + 1) {
                continue;
            }
            if (prev % 2 == 0) {
                int index = map.get(prev + 1);
                swap(row, i, index);
                map.put(prev + 1, i);
                map.put(now, index);
            } else {
                int index = map.get(prev - 1);
                swap(row, i, index);
                map.put(prev - 1, i);
                map.put(now, index);
            }
           
            count++;
        }
        return count;
    }
    
    private void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}
