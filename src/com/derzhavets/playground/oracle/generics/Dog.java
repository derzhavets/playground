package com.derzhavets.playground.oracle.generics;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println(name + " barks at this food");
	}
}
