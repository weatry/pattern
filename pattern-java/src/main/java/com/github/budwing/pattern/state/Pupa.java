package com.github.budwing.pattern.state;

public class Pupa implements ButterflyState {

	public void eat() {
		System.out.println("Pupa does not eat.");
	}

	public void fly() {
		System.out.println("Pupa cannot fly during metamorphosis.");
	}

	public void walk() {
		System.out.println("Pupa is immobile—no walking.");
	}

}
