package algorithms.sorting;

import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args) {
//		int[] a1 = {-1, 9, 8, 10, -5, 11, -8, 6, 20, 13, -4, -2, 10, 31, 20, 12, 11, 30, 12};
//		int[] a2 = {-1, 9, 8, 10, -5, 11, -8, 6, 20, 13, -4, -2, 10, 31, 20, 12, 11, 30, 12};
//		
//		for(int i = 1; i <= a1.length; i++) {
//			System.out.println(i + "-th smallest element with simple iterate: " + selectIthElement(a1, i));
//			System.out.println(i + "-th smallest element with Randomized-Select: " + randomizedSelectI(a1, 0, a1.length-1, i));
//		}
//		
//		quickSort(a1, 0, a1.length-1);
//		randomizedQuickSort(a2, 0, a2.length-1);
//		for(int j=0; j<a1.length; j++) {
//			System.out.print(j + "\t");
//		}
//		System.out.println();
//		print(a1);
//		print(a2);
		int[] nums = {1,2,3,4,5,6,8,9,10,7};
		System.out.println(selectIthElement(nums, 10));
	}
	
	static Random rand = new Random();
	public static int selectIthElement(int[] a, int k) {
		if(k >= a.length || a.length <= 1) return a[a.length - 1];
		int low = 0, high = a.length - 1;
		int q = -1, pos = q - low + 1;
		while(pos != k) {
			if(k < pos) {
				high = q - 1;
			} else {
 				low = q + 1;
				k = k - pos;
			}
			q = randomizedPartition(a, low, high);
			pos = q - low + 1;
		}
		
		return a[q];
	}
	
	public static int randomizedPartition(int[] a, int l, int r) {
		int p = rand.nextInt(r - l + 1) + l;
		swap(a, p, r);
		return partition(a, l, r);
	}
	
	public static int partition(int[] a, int l, int r) {
		int pos = l;
		int pivot = a[r];
		for(int j = l; j < r; j++) {
			if(a[j] <= pivot) {
				swap(a, pos, j);
				pos++;
			}
		}
		swap(a, pos, r);
		return pos;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int randomizedSelectI(int[] a, int l, int r, int k) {
		if(l == r) return a[l];
		int pivot = randomizedPartition(a, l, r);
		int index = pivot - l + 1;
		if(index == k) return a[pivot];
		else if (k < index) {
			return randomizedSelectI(a, l, pivot - 1, k);
		} else {
			return randomizedSelectI(a, pivot + 1, r, k - index);
		}
	}
	
	public static void quickSort(int[] a, int p, int r) {
		if(p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}
	
	public static void randomizedQuickSort(int[] a, int p, int r) {
		if(p < r) {
			int q = randomizedPartition(a, p, r);
			randomizedQuickSort(a, p, q-1);
			randomizedQuickSort(a, q+1, r);
		}
	}
	
	public static void print(int[] a) {
		for(int i : a) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}