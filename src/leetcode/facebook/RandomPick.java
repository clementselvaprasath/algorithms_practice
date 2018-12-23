package leetcode.facebook;

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
        	if (!map.containsKey(nums[i])) {
        		map.put(nums[i], new ArrayList<>());
        	}
        	map.get(nums[i]).add(i);
        }
        
        this.nums = nums;
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
    
    // for data streaming model
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
