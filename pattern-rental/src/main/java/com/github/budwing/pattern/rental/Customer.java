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
		double totalAmount = getTotalCharges();
		
		int frequentRenterPoints = getTotalFrequentRenterPoints();
		
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental:rentals) {
			result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
		}
		
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for(Rental rental:rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private double getTotalCharges() {
		double totalAmount = 0;
		for(Rental rental:rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
}
