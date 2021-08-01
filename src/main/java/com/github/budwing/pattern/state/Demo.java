package com.github.budwing.pattern.state;

public class Demo {
	public static void main(String[] args) {
		ButterFlyState state = new Grub();
		ButterFly fly = new ButterFly();
		fly.setState(state);
		fly.walk();
	}
}
