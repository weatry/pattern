package com.github.budwing.pattern.rental.test;

import com.github.budwing.pattern.rental.Customer;
import com.github.budwing.pattern.rental.Movie;
import com.github.budwing.pattern.rental.Price;
import com.github.budwing.pattern.rental.Rental;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomer {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStatement() {
		Customer tom = new Customer("tom");
		Movie m1 = new Movie("Avantar", Price.REGULAR);
		Movie m2 = new Movie("The Transformer", Price.NEW_RELEASE);
		Movie m3 = new Movie("Sherk", Price.CHILDREN);
		
		tom.addRental(new Rental(m1, 3));
		tom.addRental(new Rental(m2, 4));
		tom.addRental(new Rental(m3, 5));
		
		String statement = tom.statement();
		System.out.println(statement);
		Assert.assertTrue(statement.contains("\tAvantar\t3.5"));
		Assert.assertTrue(statement.contains("\tThe Transformer\t12.0"));
		Assert.assertTrue(statement.contains("\tSherk\t4.5"));
		Assert.assertTrue(statement.contains("Amount owed is 20.0"));
		Assert.assertTrue(statement.contains("You earned 4 frequent renter points"));
		
	}

}
