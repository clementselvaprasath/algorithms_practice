package datastructure;

public class Queue<E> {
	E[] a;
	int head;
	int tail;

	public Queue(E[] e) {
		this.a = e;
		this.head = 0;
		this.tail = 0;
	}
	
	public void enqueue(E e) throws Exception {
		if(fullQueue()) throw new Exception("Queue overflow.");
		a[tail] = e;
		if(tail == a.length-1) {
			tail = 0;
		} else tail++;
		
	}
	
	public E dequeue() throws Exception {
		if(emptyQueue()) throw new Exception("Queue underflow.");
		E e = a[head];
		if(head == a.length-1) {
			head = 0;
		} else head++;
		return e;
	}
	
	public boolean emptyQueue() {
		return head == tail;
	}
	
	public boolean fullQueue() {
		return head == tail + 1;
	}
}
