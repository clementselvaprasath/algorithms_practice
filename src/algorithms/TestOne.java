package algorithms;

public class TestOne {
	public static void main(String[] args) {

		CLSImpl clsImpl = new CLSImpl("abbbcabc".toCharArray(), "ssdjfhjkaakdjjhajf".toCharArray());
		String s = clsImpl.LCS(clsImpl.a, clsImpl.b, clsImpl.a.length, clsImpl.b.length);
		System.out.println("LCS:" + s);
	}
}

class CLSImpl {
	String[][] lcs_cache;
	char[] a;
	char[] b;

	CLSImpl(char[] a, char[] b) {
		lcs_cache = new String[a.length][b.length];
		this.a = a;
		this.b = b;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				lcs_cache[i][j] = "";
			}
		}
	}

	String LCS(char[] a, char[] b, int ch_array_1_length, int ch_array_2_length) {
		if (ch_array_1_length <= 0 || ch_array_2_length <= 0) {
			return "";
		}
		if (lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1].equals("")) {
			if (a[ch_array_1_length - 1] == (b[ch_array_2_length - 1])) {
				lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1] = LCS(a, b, ch_array_1_length - 1,
						ch_array_2_length - 1) + a[ch_array_1_length - 1];

				return lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1];
			} else {
				String s1 = LCS(a, b, ch_array_1_length - 1, ch_array_2_length);
				String s2 = LCS(a, b, ch_array_1_length, ch_array_2_length - 1);
				if (s1.length() > s2.length()) {
					lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1] = s1;
					return s1;
				}
				lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1] = s2;
				return s2;
			}
		} else {
			return lcs_cache[ch_array_1_length - 1][ch_array_2_length - 1];
		}
	}
}
