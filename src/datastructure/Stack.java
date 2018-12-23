package datastructure;

public class Stack<E> {
	E[] a;
	int top;
	int size;
	
	public Stack() {}
	
	public Stack (E[] e) {
		this.a = e;
		top = 0;
		size = e.length;
	}
	
	public boolean emptyStack() {
		return top == 0;
	}
	
	public void push(E e) throws Exception {
		if(top == a.length - 1) throw new Exception("Stack overflow.");
		top++;
		a[top] = e;
	}
	
	public E pop() throws Exception {
		if(emptyStack()) throw new Exception("Stack underflow.");
		E e = a[top];
		top--;
		return e;
	}
	
	public E top() {
		return a[top];
	}
	
	public E peek() {
		return a[top];
	}
}
