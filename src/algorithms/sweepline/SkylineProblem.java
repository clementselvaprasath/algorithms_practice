package algorithms.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
 * LeetCode 218
 */
public class SkylineProblem {

	public static void main(String[] args) {
		int[][] b = {
				{2, 9, 10}, 
				{3, 7, 15}, 
				{5, 12, 12}, 
				{15, 20, 10}, 
				{19, 24, 8}
		};
		
		List<int[]> res = getSkyline(b);
		for (int[] a : res) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        
        List<int[]> blocks = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            blocks.add(new int[]{b[0], -b[2]});
            blocks.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(blocks, (a, b) -> (a[0] == b[0]? a[1] - b[1] : a[0] - b[0]));
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 1);
        int prev = 0;
        for (int[] b : blocks) {
            // end of one block
            if (b[1] < 0) {
                map.put(-b[1], map.getOrDefault(-b[1], 0) + 1);
            } else {
                if (map.get(b[1]) == 1) {
                    map.remove(b[1]);
                } else {
                    map.put(b[1], map.getOrDefault(b[1], 0) - 1);
                }
            }
            
            int cur = map.lastKey();
            if (prev != cur) {
                res.add(new int[]{b[0], cur});
                prev = cur;
            }
        }
        
        return res;
    }
}
