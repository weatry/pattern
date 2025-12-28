package com.github.budwing.pattern.strategy;

public class OrderInOldStyle {
	private CustomerInOldStyle customer;

	public OrderInOldStyle(CustomerInOldStyle customer) {
		this.customer = customer;
	}

	public float calculatePrice(float amount) {
		if ("ordinary".equals(customer.getType())) {
			return amount * 0.85f;
		} else {
			return amount * 0.7f;
		}
	}

	public CustomerInOldStyle getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInOldStyle customer) {
		this.customer = customer;
	}
}
