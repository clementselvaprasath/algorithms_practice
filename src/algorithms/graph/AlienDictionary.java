package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		System.out.println((char)('a' + 2));

	}

	public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];
        
        Map<Character, List<Character>> map = new HashMap<>();
        int n = words.length;
        for (int i = 1; i < n; i++) {
        	updateMap(words[i - 1].toCharArray(), words[i].toCharArray(), map);
        }

        int[] indegree = new int[26];
        for (Character c : map.keySet()) {
        	List<Character> list = map.get(c);
        	for (Character cc : list) {
        		indegree[cc - 'a']++;
        	}
        }

        Queue<Character> q = new LinkedList<>();
        for (Character c : map.keySet()) {
        	if (indegree[c - 'a'] == 0) {
        		q.offer(c);
        	}
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
        	Character c = q.poll();
        	sb.append(c);
        	count++;
        	for (Character cc : map.get(c)) {
        		int index = cc - 'a';
        		indegree[index]--;
        		if (indegree[index] == 0) {
        			q.offer(cc);
        		}
        	}
        }

        return count == map.size()? sb.toString() : "";
    }

    private void updateMap(char[] c1, char[] c2, Map<Character, List<Character>> map) {
    	int size = Math.min(c1.length, c2.length);
    	int i = 0;
    	for (i = 0; i < size; i++) {
    		if (!map.containsKey(c1[i])) {
				map.put(c1[i], new ArrayList<>());
			}
			if (!map.containsKey(c2[i])) {
				map.put(c2[i], new ArrayList<>());
			}
    		if (c1[i] == c2[i]) {
    			continue;
    		} else {
    			map.get(c1[i]).add(c2[i]);
    			break;
    		}
    	}
    	size = Math.max(c1.length, c2.length);
    	for (int j = i; j < size; j++) {
    		if (j < c1.length && !map.containsKey(c1[j])) {
				map.put(c1[j], new ArrayList<>());
			}
			if (j < c2.length && !map.containsKey(c2[j])) {
				map.put(c2[j], new ArrayList<>());
			}
    	}
    }
}
