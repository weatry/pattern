package com.github.budwing.pattern.rental;

public class Movie {
	private String title;
	private Price price;
	
	public Movie(String title, int priceCode) {
		super();
		this.title = title;
		switch(priceCode) {
		case Price.REGULAR:
			price = new RegularPrice();
			break;
		case Price.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case Price.CHILDREN:
			price = new ChildrenPrice();
			break;
		}
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
