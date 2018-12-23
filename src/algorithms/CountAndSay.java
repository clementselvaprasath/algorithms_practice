package algorithms;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}

	public static String countAndSay(int n) {
		if (n == 0)
			return "1";
		if (n == 1)
			return "1";

		String p = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder();
		char[] c_array = p.toCharArray();

		int count = 0;
		char head = c_array[0];
		for (int i = 0; i < c_array.length; i++) {
			if (c_array[i] == head) {
				count++;
			} else {
				sb.append("" + count + head);
				count = 0;
				head = c_array[i];
			}
		}
		sb.append("" + count + head);

		return sb.toString();
	}
}
