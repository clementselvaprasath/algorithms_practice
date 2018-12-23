package leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 * 
 * @author qz
 *
 */
public class ReadNCharactersGivenRead4_MultipleCall {

	public static void main(String[] args) {

	}

	Queue<Character> q = new LinkedList<>();
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        while (n > 0) {
            if (q.isEmpty()) {
                char[] tmp = new char[4];
                int count = read4(tmp);
                if (count == 0) return res;
                for (int i = 0; i < count; i++) {
                    q.offer(tmp[i]);
                }
            }
            int i = 0, min = Math.min(q.size(), n);
            while (i < min) {
                buf[res + i] = q.poll();
                i++;
            }
            res += i;
            n -= min;
        }

        return res;
    }
	private int read4(char[] tmp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
