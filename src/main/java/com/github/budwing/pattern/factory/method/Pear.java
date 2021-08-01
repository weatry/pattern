package com.github.budwing.pattern.factory.method;

public class Pear extends Plant {

	public Fruit generateFruit() {
		return new PearFruit();
	}

}
