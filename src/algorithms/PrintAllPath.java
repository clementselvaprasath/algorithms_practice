package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {

	public static void main(String[] args) {
		int m = 3, n = 4;
		printAllPath(m, n);
	}

	public static void printAllPath (int m, int n) {
		List<List<String>> result = getAllPath (m, n, 0, 0);
		for (List<String> list : result) {
			for (int i = list.size() - 1; i >= 0 ; i--) {
				System.out.print(list.get(i));
				if (i > 0) {
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> getAllPath (int m, int n, int start, int end) {
		List<List<String>> result = new ArrayList<>();
		String val = "( " + start + ", " + end + " )";
		if (start == m - 1 && end == n - 1) {
			List<String> r = new ArrayList<>();
			r.add(val);
			result.add(r);
			return result;
		}
		
		if (start < m - 1) {
			List<List<String>> down = getAllPath (m, n, start + 1, end);
			for (List<String> list : down) {
				list.add(val);
			}
			result.addAll(down);
		}
		if (end < n - 1) {
			List<List<String>> right = getAllPath (m, n, start, end + 1);
			for (List<String> list : right) {
				list.add(val);
			}
			result.addAll(right);
		}
		
		return result;
	}
}
