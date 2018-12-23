package datastructure;

public class MultipleStacksInOneArray {
	Node[] a;
	int[] tops;
	Node free;
	
	private class Node {
		public int val;
		public Node next;
		
		public Node (){}
		
		public Node (int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public MultipleStacksInOneArray() {
		a = new Node[20];
		tops = new int[2];
		
		free = new Node(0, null);
		Node cursor = free;
		for(int i=1; i<a.length; i++) {
			Node n = new Node(1, null);
			cursor.next = n;
			cursor = n;
		}
	}
	
	public MultipleStacksInOneArray(int array_size, int stacks_num) {
		a = new Node[array_size];
		tops = new int[stacks_num];
		
		free = new Node(0, null);
		Node cursor = free;
		for(int i=1; i<a.length; i++) {
			Node n = new Node(1, null);
			cursor.next = n;
			cursor = n;
		}
	}
	
	public void push(int stack, int val) throws Exception {
		if(isFull()) throw new Exception("Stack overflow.");
		Node n = free;
		free = free.next;
		tops[stack] = n.val;
	}
	
	public boolean isFull () {
		return free == null;
	}
}
