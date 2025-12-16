package com.github.budwing.pattern.strategy;

public class ShopInOldStyle {
	public float calculatePrice(CustomerInOldStyle customer, float amount) {
		if("ordinary".equals(customer.getType())) {
			return amount*0.85f;
		} else {
			return amount*0.7f;
		}
	}
}
