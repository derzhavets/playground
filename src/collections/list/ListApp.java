package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lambda.basics.Person;

public class ListApp {
	
	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		
		Stream.of("Mike", "Ameed", "Omer", "Edan", "Alex", "Sol", "Miri", "Stanley", "Wiki")
		.forEach(name -> {
			people.add(new Person(name));
		});
		
		System.out.println("Mapping names to new list");
		List<String> names = people.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.println(names);
		
		System.out.println("Swapping elements with swap method");
		swap(names, 2, 5);
		System.out.println(names);
		
		System.out.println("Shuffling elements with shuffle method");
		shuffle(names, new Random());
		System.out.println(names);
		
		System.out.println("Iterating with iterator");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		System.out.println("Creating sublist");
		List<String> sublist = names.subList(3, 7);
		System.out.println(sublist);
		
	}

	public static <E> void swap(List<E> list, int i, int j) {
		  E tmp = list.get(i);
		  list.set(i, list.get(j));
		  list.set(j, tmp);
	}
	
	public static void shuffle(List<?> list, Random rnd) {
		for (int i = list.size(); i > 1; i--) {
			swap(list, i - 1, rnd.nextInt(i));
		}
	}
}
