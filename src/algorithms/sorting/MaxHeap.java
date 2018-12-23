package algorithms.sorting;

public class MaxHeap {
	
	private int[] data;
	private int size;
	
	public MaxHeap () {}
	public MaxHeap (int[] a) {
		this.data = a;
	}
	
	private void maxHeapify(int[] a, int i) {
		int largest = i;
		int l = left(i);
		int r = right(i);
		if(l <= size && a[l] > a[i]) {
			largest = l;
		}
		if(r <= size && a[r] > a[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			maxHeapify(a, largest);
		}
	}
	
	private void buildMaxHeap(int[] a) {
		size = a.length - 1;
		for(int i = parent(size); i >= 0; i--) {
			maxHeapify(a, i);
		}
		print(a);
	}
	
	public void heapSort(int[] a) {
		buildMaxHeap(a);
		for(int i = size; i >= 1; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			size--;
			maxHeapify(a, 0);
		}
	}
	
	public void maxHeapInsert(int i) {
		
	}
	
	public int heapExtractMax() {
		return 0;
	}
	
	public void heapIncreaseKey() {
		
	}
	
	public void heapMaximum() {
		
	}
	
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private int left(int i) {
		return i * 2 + 1;
	}
	
	private int right(int i) {
		return i * 2 + 2;
	}
	
	private int size() {
		return size;
	}
	
	public void print(int[] a) {
		for(int i : a) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
