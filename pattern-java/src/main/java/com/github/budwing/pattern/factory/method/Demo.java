package com.github.budwing.pattern.factory.method;

public class Demo {

	public static void main(String[] args) {
		Plant p = new Peach();
		Fruit f = p.generateFruit();
	}

}
