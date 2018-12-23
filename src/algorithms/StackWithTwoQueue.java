package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	void push(int v) {
		if(q1.isEmpty() && q2.isEmpty()) {
			q1.add(v);
		} else {
			if(!q1.isEmpty()) {
				q1.add(v);
			} else {
				q2.add(v);
			}
		}
	}
	
	Integer pop() {
		if(q1.isEmpty() && q2.isEmpty()) return null;
		
		Integer val = null;
		if(!q1.isEmpty()) {
			while(q1.size() > 1) {
				int a = q1.remove();
				q2.add(a);
			}
			val = q1.remove();
		} else {
			while(q2.size() > 1) {
				int a = q2.remove();
				q1.add(a);
			}
			val = q2.remove();
		}
		return val;
	}

	public static void main(String[] args) {
		StackWithTwoQueue queue = new StackWithTwoQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
