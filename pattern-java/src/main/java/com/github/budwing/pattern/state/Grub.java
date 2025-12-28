package com.github.budwing.pattern.state;

public class Grub implements ButterflyState {

	public void eat() {
		System.out.println("Grub eats leaves constantly.");
	}

	public void fly() {
		System.out.println("Grub cannot fly.");
	}

	public void walk() {
		System.out.println("Grub crawls on the ground.");
	}

}
