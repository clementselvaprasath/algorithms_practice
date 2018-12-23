package algorithms.sorting;

import java.util.Arrays;

/**
 * Give a new alphabet, such as
 * {c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}. Sort the string array
 * according to the new alphabet
 * 
 * Notice The length of word does not exceed 100. The number of words does not
 * exceed 10000. You can assume that the given new alphabet is a 26-character
 * string. Only lowercase letters.
 * 
 * Example Given Alphabet =
 * {c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}, String array =
 * {cab,cba,abc}, return {cba,cab,abc}.
 * 
 * Explanation: According to the new dictionary order, output the sorted result
 * {cba, cab, abc}. Given Alphabet =
 * {z,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,c}, String array =
 * {bca,czb,za,zba,ade}, return {zba,za,bca,ade,czb}.
 * 
 * Explanation: According to the new dictionary order, output the sorted result
 * {zba,za,bca,ade,czb}.
 * 
 * @author qz
 *
 */
public class WordSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] wordSort(char[] alphabet, String[] words) {

		char[] map = new char[26];
		for (int i = 0; i < 26; i++) {
			map[alphabet[i] - 'a'] = (char) ('a' + i);
		}

		Arrays.sort(words, (a, b) -> {
			StringBuilder builderA = new StringBuilder();
			StringBuilder builderB = new StringBuilder();
			for (int i = 0; i < a.length(); i++) {
				builderA.append(String.valueOf(map[a.charAt(i) - 'a']));
			}
			for (int i = 0; i < b.length(); i++) {
				builderB.append(String.valueOf(map[b.charAt(i) - 'a']));
			}
			return builderA.toString().compareTo(builderB.toString());
		});

		return words;
	}
}
