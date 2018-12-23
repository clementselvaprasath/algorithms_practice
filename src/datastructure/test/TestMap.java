package datastructure.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
		}
		Set<Integer> set = map.keySet();
		List<Integer> l = new ArrayList<Integer>();
	}
}
