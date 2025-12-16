package com.github.budwing.pattern.factory.method;

public class Peach extends Plant {

	public Fruit generateFruit() {
		return new PeachFruit();
	}

}
