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
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental:rentals) {
			result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
		}
		
		result += "Amount owed is " + getTotalCharges() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		
		return result;
	}

	public int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for(Rental rental:rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public double getTotalCharges() {
		double totalAmount = 0;
		for(Rental rental:rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
}
