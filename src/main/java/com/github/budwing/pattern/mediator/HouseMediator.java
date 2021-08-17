package com.github.budwing.pattern.mediator;

public class HouseMediator extends Mediator {
	private HouseOwner owner;
	private HouseRenter renter;
	private TaxAdmin tax;

	public void rentHouse(HouseRenter renter) {
		this.renter = renter;
	}

	public void rentOutHouse(HouseOwner owner) {
		this.owner = owner;
	}
	
	public void deal() {
		if (owner != null && renter != null) {
			owner.receivePayment(renter.pay());
			tax.receive(30);
		}
	}
}
