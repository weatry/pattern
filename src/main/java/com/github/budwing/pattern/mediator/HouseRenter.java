package com.github.budwing.pattern.mediator;

public class HouseRenter {
	private HouseMediator mediator;

	public void rent() {
		mediator.rentHouse(this);
	}

	public float pay() {
		//mediator
		return 3000;
	}
}
