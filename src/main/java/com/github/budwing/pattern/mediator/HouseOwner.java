package com.github.budwing.pattern.mediator;

public class HouseOwner {
	private HouseMediator mediator;

	public void rentOut() {
		mediator.rentOutHouse(this);
	}
	public void receivePayment(float money) {
		//
	}

}
