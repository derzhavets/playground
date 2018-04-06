package com.derzhavets.playground.oracle.lambda.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersonApp {
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		Stream.of("Mike", "Ameed", "Omer", "Edan", "Alex", "Sol", "Miri", "Stanley", "Wiki")
			.forEach(name -> {
				persons.add(new Person(name));
		});
		
		System.out.println("Printing older than 20");
		Person.printOlderThan(persons, 20);
		System.out.println();
		
		System.out.println("Printing between 20 and 40 with regular shit");
		Person.printWithingAgeRane(persons, 20, 40);
		System.out.println();
		
		System.out.println("Printing eligible persons with external tester class");
		CheckPersonEligible tester = new CheckPersonEligible();
		Person.printPersons(persons, tester);
		
		System.out.println("Sort hot chicks with anonymus class tester");
		Person.printPersons(persons, new CheckPerson() {
			public boolean test(Person p) {
				return  p.gender == Person.Sex.FEMALE &&
						p.getAge() > 16 &&
						p.getAge() <= 30;
			}
		});
		System.out.println();
		
		System.out.println("Get older chicks with lambda");
		Person.printPersons(persons, 
				p -> p.getAge() > 30 && 
				p.gender == Person.Sex.FEMALE
		);
		System.out.println();
		
		System.out.println("Get older chicks with lambda and Predicate");
		Person.printPersonsWithPredicate(persons, 
				p -> p.getAge() > 30 && 
				p.gender == Person.Sex.FEMALE
		);
		System.out.println();
		
		System.out.println("Get older chicks with lambda and Predicate and Consume");
		Person.processPersons(persons, 
				p -> p.getAge() > 30 &&
				p.gender == Person.Sex.FEMALE,
				p -> System.out.println(p + " is from Consumer"));
		System.out.println();
		
		System.out.println("Get older chicks with lambda and Predicate and Consume and Function");
		Person.ProcessPersonsWithFunction(persons, 
				p -> p.getAge() > 30 &&
						p.gender == Person.Sex.FEMALE, 
				p -> p.getName(), 
				name -> System.out.println(name));
		System.out.println();
		
		System.out.println("Get older chicks with generalized function");
		Person.ProcessPersonsGenerally(persons, 
				p -> p.getAge() > 30 &&
				p.gender == Person.Sex.FEMALE, 
				p -> p.getName(), 
				name -> System.out.println(name));
		System.out.println();
		
		System.out.println("Get older chicks with Stream");
		persons.stream()
			.filter(p -> p.getAge() > 30 && p.gender == Person.Sex.FEMALE)
			.map(p -> p.getName())
			.forEach(name -> System.out.println(name));
	}
}
