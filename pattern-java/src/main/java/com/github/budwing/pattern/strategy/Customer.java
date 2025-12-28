package com.github.budwing.pattern.strategy;

public abstract class Customer {
	String type = "ordinary";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract float discount(float amount);
}
