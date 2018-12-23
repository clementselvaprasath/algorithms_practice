package algorithms.sorting;

public abstract class Heap {
	int[] a;
	int size;
	
	public Heap(){
		size = 0;
	}
	
	public Heap(int length) throws Exception {
		if(length <= 1) throw new Exception ("Length must be greater than 1");
		a = new int[length];
		a[0] = -1;
		size = 0;
	}
	
	public int parent(int i) {
		return i >> 1;
	}
	
	public int left(int i) {
		return i << i;
	}
	
	public int right(int i) {
		return (i << 1) + 1;
	}
	
	public int size() {
		return size;
	}
	
	public void setArray(int[] a) {
		this.a = a;
		size = a.length;
	}
	
	public int get(int i) {
		return a[i];
	}
	
	public void set(int index, int val) {
		a[index] = val;
	}
	
	public abstract void maxHeapify(int i);
}
