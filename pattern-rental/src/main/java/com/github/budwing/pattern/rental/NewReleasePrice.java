package com.github.budwing.pattern.rental;

public class NewReleasePrice extends Price {

	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

	public int getFrequentRenterPoints(int daysRented) {
		int result = 1;

		if (daysRented > 1)
			result++;

		return result;
	}

}
