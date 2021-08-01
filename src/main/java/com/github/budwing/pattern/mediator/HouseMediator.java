package com.github.budwing.pattern.mediator;

public class HouseMediator extends Mediator {
	private HouseOwner owner;
	private HouseRenter renter;
	private TaxAdmin tax;
	
	public void rentHouse() {
		owner.rentHouse(renter.ownHouse());
		tax.getTax(30);
	}
}
