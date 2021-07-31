package com.github.budwing.pattern.rental;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;
	private Price price;
	
	public Movie(String title, int priceCode) {
		super();
		this.title = title;
		this.priceCode = priceCode;
		switch(priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case CHILDREN:
			price = new ChildrenPrice();
			break;
		}
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
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
