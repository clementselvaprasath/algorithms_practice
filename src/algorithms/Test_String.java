package algorithms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test_String {
	
	public static void main(String[] args) {
		String str = "aavvbnccbc";
		System.out.println(str);
		System.out.println(removeDuplicates(str));
		System.out.println(removeDuplicatesWithSet(str));
	}
	
	private static String removeDuplicates(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		
		int tail = 1;
		char[] ca = str.toCharArray();
		for(int i = 1; i < ca.length; i++) {
			int j = 0;
			for(j = 0; j < tail; j++) {
				if (ca[i] == ca[j]) {
					break;
				}
			}
			
			if(j == tail) {
				ca[tail] = ca[i];
				tail++;
			}
		}
		
		return String.valueOf(ca).substring(0, tail);
	}
	
	private static String removeDuplicatesWithSet(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		
		Set<Character> set = new LinkedHashSet<Character>();
		for(Character c : str.toCharArray()) {
			set.add(c);
		}
		
		StringBuffer sb = new StringBuffer();
		for(Character c : set) {
			sb.append(c);
		}
		return sb.toString();
	}
}
