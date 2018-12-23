package leetcode.google;

import java.util.Stack;

/**
 * Given a list of number that indicating the speed of the cars,
 * find a way to calculate how many groups can these cars generate.
 * 
 * example: [1,2,2,3,1,2,3,1,2], ans = 3 
 * 
 * @author qz
 *
 */
public class CarGroups {

	public static void main(String[] args) {
		CarGroups c = new CarGroups();
		int[] t1 = {1,2,3,2,3,1,2,3};
		int[] t2 = {1,2,3,2,3,1,2,3,4};
		int[] t3 = {1,2,3,2,3,1,2};
		int[] t4 = {1,1,1,1,1,1};
		
		System.out.println(c.carGroups(t1));
		System.out.println(c.carGroups(t2));
		System.out.println(c.carGroups(t3));
		System.out.println(c.carGroups(t4));
	}

	public int carGroups(int[] cars) {
		if (cars.length <= 1) return cars.length;
		
		Stack<Integer> stack = new Stack<>();
		for (int i : cars) {
			while (!stack.isEmpty() && stack.peek() < i) {
				stack.pop();
			}
			stack.push(i);
		}
		
		return stack.size();
	}
	
}
