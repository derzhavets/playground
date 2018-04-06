package com.derzhavets.playground.oracle.lambda.basics;

public class CheckPersonEligible implements CheckPerson {
	public boolean test(Person p) {
		return p.gender == Person.Sex.MALE &&
				p.getAge() > 18 &&
				p.getAge() <= 25;
	}
}
