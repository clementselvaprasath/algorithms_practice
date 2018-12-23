package leetcode.google;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @author qz
 *
 */
public class ReadNCharactersGivenRead4 {

	public static void main(String[] args) {
		char c = '\f';
	}

	// read characters to buf which is size n
	public int read(char[] buf, int n) {
		if (buf == null || buf.length == 0)
			return 0;
		int res = 0;
		int count = 0;
		char[] tmp = new char[4];
		while ((count = read4(tmp)) > 0 && n > 0) {
			int min = Math.min(count, n);
			for (int i = res; i < res + min; i++) {
				buf[i] = tmp[i - res];
			}
			res += min;
			n -= min;
		}

		return res;
	}

	/**
	 * Read characters from a file and save it to buffer (char[] buf)
	 * 
	 * @param buf
	 * @return
	 */
	private int read4(char[] buf) {
		// TODO Auto-generated method stub
		return 0;
	}
}
