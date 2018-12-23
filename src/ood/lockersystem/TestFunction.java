package ood.lockersystem;

import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class TestFunction {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedBlockingDeque<>(3);
		print(deque);
		deque.offer(1);
		deque.offer(2);
		deque.offer(3);
		print(deque);
		
		deque.offer(4);
		print(deque);
		deque.offer(5);
		print(deque);
	}

	private static void print(Collection<Integer> col) {
		for (Integer i : col) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
