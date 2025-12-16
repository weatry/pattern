package com.github.budwing.pattern.strategy;

public class VIPCustomer extends Customer {

	public float calculate(float amount) {
		return amount*0.7f;
	}

}
