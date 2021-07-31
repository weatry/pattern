package com.github.budwing.pattern.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental arg) {
		rentals.add(arg);
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		
		for(Rental rental:rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
			
			result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
			totalAmount += rental.getCharge();
		}
		
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		
		return result;
	}
}
