package leetcode.google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FirstKElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {4, 1, 2, 2};
		String[] s = {"R", "Y", "G", "B"};
		int k = 5;
		List<List<Item>> res = findFirstKElements(w, s, k);
		for (List<Item> list : res) {
			for (Item str : list) {
				System.out.print(str.tag + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * Find the first K weight element.
	 * Example: you have W = {4, 1, 2, 2}, S = {R, Y, G, B}
	 *  
	 * Output: 
	 * {R, Y, G, B}
	 * {R, G, B}
	 * {R, Y, G}
	 * {R, Y, B}
	 * {R, G} or {R, B}
	 */
	public static List<List<Item>> findFirstKElements (int[] W, String[] S, int K) {
		int n = W.length;
		
		List<List<Item>> res = new ArrayList<>();
		PriorityQueue<ElementSet> pq = new PriorityQueue<ElementSet>(new Comparator<ElementSet>(){
			public int compare(ElementSet e1, ElementSet e2) {
				return e2.sum - e1.sum;
			}
		});
		
		List<Item> max = new ArrayList<Item>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += W[i];
			max.add(new Item(W[i], S[i]));
		}
		ElementSet es = new ElementSet(sum, max);
		pq.add(es);
		for (int i = 0; i < K; i++) {
			ElementSet tmp = pq.poll();
			res.add(tmp.list);
			for (int j = 0; j < tmp.list.size(); j++) {
				List<Item> nl = new ArrayList<Item>(tmp.list);
				nl.remove(j);
				pq.add(new ElementSet(tmp.sum - tmp.list.get(j).w, nl));
			}
		}
	
		return res;
	}
}

class Item {
	int w;
	String tag;
	public Item () {}
	public Item (int w, String tag) {
		this.w = w;
		this.tag = tag;
	}
}

class ElementSet {
	int sum;
	List<Item> list;
	public ElementSet () {
		sum = 0;
		list = new ArrayList<Item>();
	}
	public ElementSet (int sum, List<Item> list) {
		this.sum = sum;
		this.list = list;
	}
}
