package lambda.methodReference;

import java.util.Comparator;

import lambda.basics.Person;

public class PersonAgeComparator implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		return o1.getAge().compareTo(o2.getAge());
	}

}
