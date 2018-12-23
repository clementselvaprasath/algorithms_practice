package algorithms;

import datastructure.test.Java8Lambda;
import datastructure.test.Person;

public class Main_TestGeneric {

	public static void main(String[] args) {
		Person person = new Person();
		Java8Lambda lambda = new Java8Lambda();
		System.out.println(person.getClass().getSimpleName());
		System.out.println(check(Person.class, lambda));
	}

	private static <T> boolean check(Class<T> t, Object obj) {
	
		return t.isInstance(obj);
	}
}
