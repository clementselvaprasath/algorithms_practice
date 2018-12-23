package algorithms.arrayandlist.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Give two input stream inputA and inputB, which have Backspace. If the final
 * result of the two input streams is equal, output YES, otherwise output NO.
 * 
 * Notice Input characters include only lowercase letters and '<' The length of
 * input stream does not exceed 10000.
 * 
 * Example Given inputA = “abcde<<”, inputB = “abcd<e<”, return "YES".
 * 
 * Explanation: The final result of inputA and inputB is abc, so return "YES".
 * Given inputA = “a<<bc”, inputB = “abc<”, return "NO"
 * 
 * Explanation: The final result of inputA is "bc", and the final result of
 * inputB is "ab", so return "NO".
 * 
 * 
 * @author qz
 *
 */
public class InputStreamProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String inputStream(String inputA, String inputB) {
        if (inputA.equals(inputB)) return "YES";
        String a = getString(inputA);
        String b = getString(inputB);
        return a.equals(b)? "YES" : "NO";
    }
    
    private String getString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    
    private String getString_stack(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offer(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
