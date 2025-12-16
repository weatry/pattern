package com.github.budwing.pattern.strategy;

public class Shop {
	public float calculatePrice(Customer customer, float amount) {
		return customer.calculate(amount);
	}
}
