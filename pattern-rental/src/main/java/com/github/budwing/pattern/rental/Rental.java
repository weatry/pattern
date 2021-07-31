package com.github.budwing.pattern.rental;

public class Rental {
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() {
		double thisAmount = 0;
		
		switch(getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if(getDaysRented()>2) {
				thisAmount += (getDaysRented()-2)*1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented()*3;
			break;
		case Movie.CHILDREN:
			thisAmount += 1.5;
			if(getDaysRented()>3) {
				thisAmount += (getDaysRented()-3)*1.5;
			}
			break;
		}
		return thisAmount;
	}
}
