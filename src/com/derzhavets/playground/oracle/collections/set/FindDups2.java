package com.derzhavets.playground.oracle.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FindDups2 {
	private static List<String> words = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Stream.of("I", "See", "I", "Do", "I", "Leave", "Do", "Shit").forEach(word -> 
		words.add(word));
		
		System.out.println("Original list: " + words);
		
		Set<String> uniqs = new HashSet<>();
		Set<String> dups = new HashSet<>();
		
		words.forEach(word -> {
			if(!uniqs.add(word)) {
				dups.add(word);
			}
		});
		
		//Destructive set difference
		uniqs.removeAll(dups);
		
		System.out.println("Uniqs: (" + uniqs.size() + ") " + uniqs);
		System.out.println("Dups: (" + dups.size() + ") " + dups);
	}
	
}
