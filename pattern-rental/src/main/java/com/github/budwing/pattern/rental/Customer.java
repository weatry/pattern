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
			double thisAmount = rental.getCharge();
			
			frequentRenterPoints++;
			
			if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
					rental.getDaysRented() > 1)
				frequentRenterPoints++;
			
			result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		
		return result;
	}
}
