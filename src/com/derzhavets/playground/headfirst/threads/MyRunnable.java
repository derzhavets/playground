package com.derzhavets.playground.headfirst.threads;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		doSomething();
	}
	
	private void doSomething() {
		doMore();
	}
	
	private void doMore() {
		for (int i = 0; i < 20; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println("This is thread " + threadName);
		}
	}
}
