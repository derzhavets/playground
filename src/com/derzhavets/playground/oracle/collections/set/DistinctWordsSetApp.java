package com.derzhavets.playground.oracle.collections.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctWordsSetApp {
	
	private static List<String> words = new ArrayList<>();
	private static Set<String> subset = new TreeSet<>();
	
	public static void main(String[] args) {
		Stream.of("I", "See", "I", "Do", "I", "Leave", "Do", "Shit").forEach(word -> 
			words.add(word));
		
		Stream.of("No", "Shit").forEach(word -> subset.add(word));
		
		System.out.println("Collecting ArrayList to TreeSet to remove dups");
		Set<String> dist1 = words.stream()
				.collect(Collectors.toSet());
		System.out.println(dist1);
		
		System.out.println("dist1 contains subset: " + dist1.containsAll(subset));
		
		dist1.addAll(subset);
		System.out.println("Add all: " + dist1);
	}
}
