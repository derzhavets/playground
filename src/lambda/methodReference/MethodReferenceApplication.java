package lambda.methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import lambda.basics.Person;

public class MethodReferenceApplication {
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		Stream.of("Mike", "Ameed", "Omer", "Edan", "Alex", "Sol", "Miri", "Stanley", "Wiki")
			.forEach(name -> {
				persons.add(new Person(name));
		});
		
		System.out.println("Sorting with anon class");
		Collections.sort(persons, new PersonAgeComparator());
		Person.printCollection(persons);
		Collections.shuffle(persons);
		
		System.out.println("Sorting with lambda");
		Collections.sort(persons, (a,b) -> a.getAge().compareTo(b.getAge()));
		Person.printCollection(persons);
		Collections.shuffle(persons);
		
		System.out.println("Sorting with method reference");
		Collections.sort(persons, Person::compareByAge);
		Person.printCollection(persons);
		Collections.shuffle(persons);
		
		System.out.println("Sorting names with method reference");
		Collections.sort(persons, Person::compareByName);
		Person.printCollection(persons);
		Collections.shuffle(persons);
		
	}
}
