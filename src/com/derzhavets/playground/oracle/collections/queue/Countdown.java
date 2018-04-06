package com.derzhavets.playground.oracle.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Countdown {
	public static void main(String[] args) throws InterruptedException {
		
		int time = 5;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = time; i > 0; i--) {
			queue.add(i);
		}
			
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
	}
}
