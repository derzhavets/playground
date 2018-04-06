package com.derzhavets.playground.oracle.collections.deque;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Stream;

public class DequeApp {
	public static void main(String[] args) {
		
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8).forEach(n -> deq.add(n));
		
		System.out.println(deq);
		
		deq.addFirst(17);
		deq.addLast(38);
		System.out.println(deq);
		
		System.out.println(deq.getLast());
		
	}
}
