package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Test_Lambda {

	public static void main(String[] args) {
		List<Integer> list1 = generateIntegers();
		List<Integer> list2 = generateIntegers();
		List<Integer> list3 = generateIntegers();
		List<Integer> list4 = generateIntegers();
		List<Integer> list5 = generateIntegers();
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		System.out.println("Before the process: ================================");
		printList(list1);
		printList(list2);
		printList(list3);
		printList(list4);
		printList(list5);
		
		// add all lists to lists
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		lists.add(list5);
		
		// process
		List<Integer> result = lists.stream()
				.collect(ArrayList<Integer>::new, List::addAll, List::addAll);
		
		System.out.println("After the process: ================================");
		printList(result);
	}

	private static List<Integer> generateIntegers() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 200; i++) {
			list.add((int)(Math.random() * 100) + 1);
		}
		
		return list;
	}
	
	private static void printList(List<Integer> list) {
		for(Integer i : list) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
