package com.derzhavets.playground.oracle.lambda.basics;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person implements Comparable<Person> {
	
	public enum Sex {
		MALE, FEMALE
	}
	
	String name;
	Sex gender;
	Integer age;
	
	public Person(String name) {
		this.name = name;
		this.age = new Random().nextInt(50);
		this.gender = new Random().nextBoolean() ? Person.Sex.MALE : Person.Sex.FEMALE;
	}
	
	public static void printOlderThan(List<Person> persons, int age) {
		for (Person p : persons) {
			if (p.getAge() > age) {
				p.printPerson();
			}
		}
	}
	
	public static void printWithingAgeRane(List<Person> persons, int low, int high) {
		for (Person p : persons) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersons(List<Person> persons, CheckPerson tester) {
		for (Person p : persons) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public static void processPersons(List<Person> persons, 
			Predicate<Person> tester, 
			Consumer<Person> block) {
		for (Person p : persons) {
			if(tester.test(p)) {
				block.accept(p);
			}
		}
	}
	
	public static void printPersonsWithPredicate(List<Person> persons, Predicate<Person> tester) {
		for (Person p : persons) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public static void ProcessPersonsWithFunction(List<Person> persons,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> block) {
		for (Person p : persons) {
			if(tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	public static <X, Y> void ProcessPersonsGenerally(Iterable<X> iterable,
			Predicate<X> tester,
			Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X x : iterable) {
			if(tester.test(x)) {
				Y data = mapper.apply(x);
				block.accept(data);
			}
		}
	}
	
	public static int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}
	
	public static int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
	
	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
	
	private void printPerson() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public static <T> void printCollection(Collection<T> elements ) {
		elements.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.getName());
	}
}
