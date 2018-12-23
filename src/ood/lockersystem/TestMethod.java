package ood.lockersystem;

import java.util.function.Function;

public class TestMethod {

	public static void main(String[] args) {
		TestMethod tm = new TestMethod();
		System.out.println(tm.calculate(10, tm::plus));
		System.out.println(tm.calculate(10, tm::square));
		System.out.println(tm.calculate(10, tm::multiply5));
	}

	public int calculate(int a, Function<Integer, Integer> f) {
		return f.apply(a);
	}
	
	public int plus(int a) {
		return a + a;
	}
	
	public int square(int a) {
		return a * a;
	}
	
	public int multiply5(int a) {
		return a * 5;
	}
}
