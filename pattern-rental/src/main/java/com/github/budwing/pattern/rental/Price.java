package com.github.budwing.pattern.rental;

public abstract class Price {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public abstract double getCharge(int daysRented);
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
