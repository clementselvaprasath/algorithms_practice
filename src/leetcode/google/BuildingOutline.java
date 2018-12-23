package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BuildingOutline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given N buildings in a x-axis，each building is a rectangle and can be
	 * represented by a triple (start, end, height)，where start is the start
	 * position on x-axis, end is the end position on x-axis and height is the
	 * height of the building. Buildings may overlap if you see them from far
	 * away，find the outline of them。
	 * 
	 * An outline can be represented by a triple, (start, end, height), where
	 * start is the start position on x-axis of the outline, end is the end
	 * position on x-axis and height is the height of the outline.
	 * 
	 * 
	 * Example
Given 3 buildings：

[
  [1, 3, 3],
  [2, 4, 4],
  [5, 6, 1]
]
The outlines are：

[
  [1, 2, 3],
  [2, 4, 4],
  [5, 6, 1]
]
	 */
	public List<List<Integer>> buildingOutline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        
        List<int[]> blocks = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            blocks.add(new int[]{b[0], -b[2]});
            blocks.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(blocks, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int start = 0;
        for (int[] b : blocks) {
            if (map.isEmpty()) {
                map.put(-b[1], 1);
                start = b[0];
                continue;
            }
            
            // start point of a block
            if (b[1] < 0) {
                // draw one
                if (-b[1] > map.lastKey() && start != b[0]) {
                    res.add(Arrays.asList(start, b[0], map.lastKey()));
                    // update start point
                    start = b[0];
                }
                map.put(-b[1], map.getOrDefault(-b[1], 0) + 1);
            } else { // end point of a block
                if (map.get(b[1]) == 1) {
                    map.remove(b[1]);
                } else {
                    map.put(b[1], map.get(b[1]) - 1);
                }
                // highest one removed
                if (start != b[0] && (map.isEmpty() || b[1] > map.lastKey())) {
                    res.add(Arrays.asList(start, b[0], b[1]));
                    // update start point
                    start = b[0];
                }
            }
        }
        
        return res;
    }
}
