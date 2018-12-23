package datastructure.test;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c");
		for (int i = 0; i < list.size(); i++) {
			
		}
	}
	
	private static void printMatrix(int[][] g) {
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				System.out.print(g[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
