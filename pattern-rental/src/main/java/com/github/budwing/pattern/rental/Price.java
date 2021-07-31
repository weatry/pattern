package com.github.budwing.pattern.rental;

public abstract class Price {
	public static final Price CHILDREN = new ChildrenPrice();
	public static final Price REGULAR = new RegularPrice();
	public static final Price NEW_RELEASE = new NewReleasePrice();
	
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
