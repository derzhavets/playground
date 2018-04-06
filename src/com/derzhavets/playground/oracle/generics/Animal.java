package com.derzhavets.playground.oracle.generics;

public class Animal {
	String name;
	
	public Animal(String name) {
		super();
		this.name = name;
	}

	public void eat() {
		System.out.println(name + " is eating");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}
