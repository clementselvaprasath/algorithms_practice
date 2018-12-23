package algorithms.sorting;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TestPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(8);
		pq.add(17);
		pq.add(4);
		pq.add(5);
		pq.add(3);
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + "\t");
		}
		
		Map<String, Integer> map = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		
		
	}

}
