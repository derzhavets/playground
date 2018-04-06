package com.derzhavets.playground.oracle.generics;

import java.util.ArrayList;

public class GenericsApp {
	public static void main(String[] args) {
		GenericsApp app = new GenericsApp();
		app.go();
	}
	
	public void go() {
		Animal[] animalArray = new Animal[3];
		ArrayList<Animal> animalArrayList = new ArrayList<Animal>();
		Dog[] dogArray = new Dog[3];
		ArrayList<Dog> dogArrayList = new ArrayList<Dog>();
		
		String[] animalNames = {"Cat", "Dino", "Snake"};
		String[] dogNames = { "Sharik", "Tuzik", "Murzik"};
		
		for (int i = 0; i < 3; i++) {
			Animal a = new Animal(animalNames[i]);
			animalArray[i] = a;
			animalArrayList.add(a);
		}
		
		for (int i = 0; i < 3; i++) {
			Dog d = new Dog(dogNames[i]);
			dogArray[i] = d;
			dogArrayList.add(d);
		}
		
		printAnimals(dogArray);
		eatAnimals(dogArrayList);
	}
	
	public void printAnimals(Animal[] a) {
		for (Animal animal : a) {
			System.out.println(a);
		}
	}
	
	public <T extends Animal> void eatAnimals(ArrayList<T> a) {
		for (Animal animal : a) {
			animal.eat();
		}
	}
}
