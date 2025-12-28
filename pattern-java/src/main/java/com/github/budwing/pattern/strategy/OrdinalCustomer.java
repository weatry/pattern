package com.github.budwing.pattern.strategy;

public class OrdinalCustomer extends Customer {

	public float discount(float amount) {
		return amount * 0.85f;
	}

}
