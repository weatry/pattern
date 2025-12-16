package com.github.budwing.pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class Parent implements Observer {

	public void update(Observable arg0, Object arg1) {
		System.out.println("Parents receive "+arg1);
	}

}
