package com.github.budwing.pattern.strategy;

public class Order {
	private Customer customer;

	public Order(Customer customer) {
		this.customer = customer;
	}

	public float calculatePrice(float amount) {
		return customer.discount(amount);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
