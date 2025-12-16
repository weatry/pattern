package com.github.budwing.pattern.state;

public class ButterflyInOldStyle {
	private String state = "grub";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void walk() {
		if ("grub".equals(state)) {
			System.out.println("Grub crawls on the ground.");
		} else {
			System.out.println("Imago walks delicately on flowers.");
		}
	}

	public void fly() {
		if ("grub".equals(state)) {
			System.out.println("Grub cannot fly.");
		} else {
			System.out.println("Imago flies beautifully through the air!");
		}
	}

	public void eat() {
		if ("grub".equals(state)) {
			System.out.println("Grub eats leaves constantly.");
		} else {
			System.out.println("Imago sips nectar from blossoms.");
		}
	}
}
