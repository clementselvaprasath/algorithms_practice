package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonOA {

	public static void main(String[] args) {
		String test = "demmocracyssahfdhsjkfhksahkfhaskhfhadslhajs";
		String test1 = "aaaaaaaaaaaa";
		List<String> list = subStringsLessKDist(test1, 2);
//		for (String s : list) {
//			System.out.println(s + "\t");
//		}
		//Character[] c = {'a', 'b','a','b','c','b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j'};
		List<Character> cs = Arrays.asList('a', 'b','a','b','c','b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j');
		List<Character> cs1 = Arrays.asList('a','b','c','d','a','e','f','g','h','i','j','e');
		List<Character> cs2 = Arrays.asList('z','z','c','b','z','c','h','f','i','h','i');
		List<Character> cs3 = Arrays.asList('a','b','a','b','e','f','e');
		//System.out.println(cs3.size());
		//List<Character> inputList = new ArrayList<>(cs);
		//inputList.
		List<Integer> list2 = lengthEachScene(cs2);
		for(Integer i : list2) {
			System.out.print(i + "\t");
		}
	}

	public static List<String> subStringsLessKDist(String inputString, int num) {
		if (inputString == null || num == 0) return new ArrayList<>();
		int n = inputString.length();
		if (n < num) return new ArrayList<>();
		
		Set<String> list = new HashSet<>();
		for (int i = 0; i < n-num+1; i++) {
			String subString = inputString.substring(i, i+num);
			Set<Character> set = new HashSet<>();
			for (char c : subString.toCharArray()) {
				set.add(c);
			}
			if (set.size() + 1 == subString.length()) {
				list.add(subString);
			}
		}
		
		return new ArrayList<String>(list);
	}
	
	public static List<Integer> lengthEachScene(List<Character> inputList) {
		if (inputList == null || inputList.isEmpty()) return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int n = inputList.size();
		int maxIndex = 0;
		int start = 0;
		int i = 0;
		for (i = 0; i < n; i++) {
			Character c = inputList.get(i);
			int lastIndex = inputList.lastIndexOf(c);
			if (i <= maxIndex && lastIndex > maxIndex) maxIndex = lastIndex;
			else if (i > maxIndex) {
				res.add(i - start);
				maxIndex = inputList.lastIndexOf(c);
				start = i;
			}
		}
		if (i > start) {
			res.add(i - start);
		}
		
		return res;
	}
}
