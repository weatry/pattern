package com.github.budwing.pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class Government implements Observer {

	public void update(Observable arg0, Object arg1) {
		System.out.println("Government receive "+arg1);
	}

}
