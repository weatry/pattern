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
		
		for(Rental each:rentals) {
			double thisAmount = 0;
			
			switch(each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getDaysRented()>2) {
					thisAmount += (each.getDaysRented()-2)*1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented()*3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDaysRented()>3) {
					thisAmount += (each.getDaysRented()-3)*1.5;
				}
				break;
			}
			
			frequentRenterPoints++;
			
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
					each.getDaysRented() > 1)
				frequentRenterPoints++;
			
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		
		return result;
	}
}
