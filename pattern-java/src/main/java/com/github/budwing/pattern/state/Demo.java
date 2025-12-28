package com.github.budwing.pattern.state;

public class Demo {
	public static void main(String[] args) {
		ButterflyState state = new Grub();
		ButterflyState state1 = new Imago();

		Butterfly fly = new Butterfly();
		fly.setState(state);
		fly.walk();
		fly.setState(state1);
		fly.walk();
	}
}
