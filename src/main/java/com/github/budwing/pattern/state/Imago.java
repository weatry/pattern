package com.github.budwing.pattern.state;

public class Imago implements ButterFlyState {

	public void eat() {
		System.out.println("Imago sips nectar from blossoms.");
	}

	public void fly() {
		System.out.println("Imago flies beautifully through the air!");
	}

	public void walk() {
		System.out.println("Imago walks delicately on flowers.");
	}

}
