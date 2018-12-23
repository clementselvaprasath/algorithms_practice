package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		List<String> wlist = Arrays.asList("hot","dot","dog","lot","log","cog");
		String s = "hit";
		String t = "cog";
		System.out.println(wl.ladderLength(s, t, wlist));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wl) {
        Set<String> wordList = new HashSet<>(wl);
        if (beginWord.equals(endWord)) return 0;
        if (!wordList.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        int len = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord)) {
                    return len;
                }
                for (String str : getCandidate(s, wordList)) {
                	if (visited.contains(str)) continue;
                    q.offer(str);
                }
            }
            len++;
        }
        
        return 0;
    }
    
    private List<String> getCandidate(String str, Set<String> wordList) {
        List<String> set = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            char[] ch = str.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == str.charAt(i)) continue;
                ch[i] = j;
                String s = new String(ch);
                if (wordList.contains(s)) {
                    set.add(s);
                }
            }
        }
        
        return set;
    }
}