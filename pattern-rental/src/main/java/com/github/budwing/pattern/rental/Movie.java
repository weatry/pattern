package com.github.budwing.pattern.rental;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;
	
	public Movie(String title, int priceCode) {
		super();
		this.title = title;
		this.priceCode = priceCode;
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
		double thisAmount = 0;
		
		switch(priceCode) {
		case REGULAR:
			thisAmount += 2;
			if(daysRented>2) {
				thisAmount += (daysRented-2)*1.5;
			}
			break;
		case NEW_RELEASE:
			thisAmount += daysRented*3;
			break;
		case CHILDREN:
			thisAmount += 1.5;
			if(daysRented>3) {
				thisAmount += (daysRented-3)*1.5;
			}
			break;
		}
		return thisAmount;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		int result = 1;
		
		if((getPriceCode() == NEW_RELEASE) && 
				daysRented > 1)
			result++;
		
		return result;
	}
}
