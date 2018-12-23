package algorithms.sorting;

public class HeapSort_Main {

	public static void main(String[] args) {
		int[] a = {-1, 13, 2, 5, -8, -6, 9, 4, 10};
		
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.heapSort(a);
		
		maxHeap.print(a);
	}

}
