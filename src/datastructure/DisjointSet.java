package datastructure;

public class DisjointSet<T> {
	
	private class Node {
		public T v;
		public Node next;
		public Node () {}
		public Node (T t, Node next) {
			this.v = t;
			this.next = next;
		}
	}

	public void makeSet(T t) {
		
	}
	
	public DisjointSet<T> union(T x, T y) {
		
		return null;
	}
	
	public DisjointSet<T> findSet(T x) {
		
		return null;
	}
}
