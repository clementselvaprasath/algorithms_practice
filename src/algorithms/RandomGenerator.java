package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RandomGenerator {

	public static void main(String[] args) {
		char[] c_array = new char[]{'a', 'b', 'a', 'c', 'c', 'd', 'b', 'a', 'b', 'a'};
		
		int time = 50000;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		long seed = System.currentTimeMillis();
		for(int i = 0; i < time; i++) {
			char c = getChar(c_array, seed);
			seed = seed * 71 % 97 + System.currentTimeMillis();
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for(Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println("" + entry.getKey() + ": " + ((double)entry.getValue() / time * 100) + " %");
		}
	}
	
	public static char getChar(char[] c, long seed) {
		int n = c.length;
		return c[(int) (seed % n)];
		//return c[(int) (Math.random() * 10)];
	}
}
