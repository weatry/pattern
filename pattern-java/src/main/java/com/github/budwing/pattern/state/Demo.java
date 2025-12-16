package com.github.budwing.pattern.state;

public class Demo {
	public static void main(String[] args) {
		ButterFlyState state = new Grub();
		ButterFlyState state1 = new Imago();

		ButterFly fly = new ButterFly();
		fly.setState(state);
		fly.walk();
		fly.setState(state1);
		fly.walk();
	}
}
