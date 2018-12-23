package algorithms.arrayandlist;

import java.util.HashMap;
import java.util.Map;

public class MinimizeString {

	public static void main(String[] args) {
		MinimizeString m = new MinimizeString();
		String input = "you say4'''yes yes, I say no you say'''''6'''6'''yes stop and I say go go go";
		
		System.out.println(m.minimize(input));
	}

	public String minimize(String input) {
		if (input == null || input.isEmpty()) return input;
		
		String[] words = input.split("\\s+");
		Map<String, String> ids_map = new HashMap<>();
		
		int id = 0;
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			String[] ww = word.split("[^a-zA-Z]+");
			for (int i = 0; i < ww.length; i++) {
				String w = ww[i];
				int index = word.indexOf(w);
				String str = w;
				if (ids_map.containsKey(w)) {
					str = ids_map.get(w);
				} else {
					ids_map.put(w, "$" + id);
				}
				id++;
				if (index > 0) {
					sb.append(word.substring(0, index));
				}
				sb.append(str);
				word = word.substring(index + w.length());
			}
			if (!word.isEmpty()) {
				sb.append(word);
			}
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
}
