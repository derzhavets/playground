package com.derzhavets.playground.oracle.aggregate;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class Employee {
	
	private static String[] cities = {"New York", "Palo Alto", "LA", "San Diego", "San Francisco"};
	private static String[] departments = {"Sales", "Marketing", "R&D", "Engineering", "Support"};
	
	private String name;
	private String department;
	private int salary;
	private int grade;
	private String city;
	
	public Employee(String name) {
		this.name = name;
		this.department = departments[new Random().nextInt(departments.length)];
		this.city = cities[new Random().nextInt(cities.length)];
		this.grade = new Random().nextInt(101);
		this.salary = new Random().nextInt(100) * 1000;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	public int getGrade() {
		return grade;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("| %-10s| %-15s| %-15s| %-10d| %-10d|", 
				name, department, city, grade, salary);
	}
	
	public static <K, E> void printMap(Map<K, List<E>> collection) {
		collection.forEach((k, v) -> {
			System.out.println("* Sorting criteria: " + k);
			v.forEach(e -> System.out.println(e));
		});
	}
	
}
