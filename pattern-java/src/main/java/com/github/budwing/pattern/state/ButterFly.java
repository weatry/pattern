package com.github.budwing.pattern.state;

public class Butterfly {
	private ButterflyState state;

	public ButterflyState getState() {
		return state;
	}

	public void setState(ButterflyState state) {
		this.state = state;
	}

	public void walk() {
		state.walk();
	}

	public void fly() {
		state.fly();
	}

	public void eat() {
		state.eat();
	}
}
