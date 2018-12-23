package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPick {
	Random rand;
	int[] nums;
    Map<Integer, List<Integer>> map;

    public RandomPick(int[] nums) {
        rand = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        
        this.nums = nums;
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
    
    public int pick_array(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != target) continue;
        	if (rand.nextInt(++count) == 0) {
        		res = i;
        	}
        }
        
        return res;
    }
}
