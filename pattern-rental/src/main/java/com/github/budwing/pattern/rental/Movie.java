package com.github.budwing.pattern.rental;

public class Movie {
	private String title;
	private Price price;
	
	public Movie(String title, Price price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		
		return price.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
