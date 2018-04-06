package com.derzhavets.playground.oracle.collections.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.derzhavets.playground.oracle.lambda.basics.Person;

public class setApplication {
	public static void main(String[] args) {
		
List<Person> persons = new ArrayList<>();
		
		Stream.of("Mike", "Ameed", "Omer", "Sol", "Alex", "Sol", "Miri", "Mike", "Wiki")
			.forEach(name -> {
				persons.add(new Person(name));
		});
		
		System.out.println("Remove duplicates using conversion constructor");
		Collection<Person> noDupConstr = new TreeSet<Person>(persons);
		Person.printCollection(noDupConstr);
		
		System.out.println("Mapping Person names to a new set");
		Set<String> s = persons.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
		Person.printCollection(s);
		
	}
}
