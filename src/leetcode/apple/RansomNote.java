package leetcode.apple;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 */
public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String R = "bgl";
		String S = "basdgkksdl";
	}

	public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.equals(ransomNote)) return true;
        if (magazine.length() < ransomNote.length()) return false;
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < m.length; i++) {
            map[m[i] - 'a']++;
        }
        for (int i = 0; i < r.length; i++) {
            if (map[r[i] - 'a'] == 0) return false;
            map[r[i] - 'a']--;
        }
        return true;
    }
}
