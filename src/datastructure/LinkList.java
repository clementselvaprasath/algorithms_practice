package datastructure;

public class LinkList<E> {
	
	Node head = new Node();
	
	private class Node {
		E val;
		Node next;
		
		public Node (){}
		
		public Node (E val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public E deleteHead () {
		if(head == null) return null;
		
		E deleteVal = head.next.val;
		head.next = head.next.next;
		return deleteVal;
	}
	
	/**
	 * delete node in the link list
	 * 
	 * @param val
	 * @return
	 */
	public E delete (E val) {
		// you code here
		return null;
	}
	
	public void insertHead (E val) {
		Node newNode = new Node(val, null);
		newNode.next = head.next;
		head.next = newNode;
	}
	
	/**
	 * 
	 * insert node after parent node
	 * 
	 * @param p		parent node
	 * @param val	value will be inserted
	 */
	public void insertAfter(E p, E val) {
		// you code here
	}
	
	public void printList(){
		Node cursor = head.next;
		while(cursor != null) {
			System.out.print(cursor.val + "\t");
			cursor = cursor.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkList<Integer> list = new LinkList<Integer>();
		list.insertHead(1);
		list.insertHead(2);
		list.insertHead(3);
		list.insertHead(4);
		list.insertHead(5);
		list.printList();
		list.deleteHead();
		list.printList();
	}
}
