package com.github.budwing.pattern.state;

public class ButterFly {
	private ButterFlyState state;

	public ButterFlyState getState() {
		return state;
	}

	public void setState(ButterFlyState state) {
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
