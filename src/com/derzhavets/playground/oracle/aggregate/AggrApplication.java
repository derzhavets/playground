package com.derzhavets.playground.oracle.aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggrApplication {
	
	private static List<Employee> employees = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Stream.of("Paul", "John", "Wiki", "Stan", "Ridley", "Dick", "Rose", "Inga", "Yoni")
			.forEach(name -> employees.add(new Employee(name)));
		
		System.out.println("Sort employees by department");
		Map<String, List<Employee>> byDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		Employee.printMap(byDep);
		System.out.println();
		
		System.out.println("Map names to salaries");
		Map<String, Integer> sal = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));
		System.out.println(sal);
		System.out.println();
		
		System.out.println("Compute sum of salaries by department");
		Map<String, Integer> sumByDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.summingInt(Employee::getSalary)));
		System.out.println(sumByDep);
		System.out.println();
		
		
		
	}
}
