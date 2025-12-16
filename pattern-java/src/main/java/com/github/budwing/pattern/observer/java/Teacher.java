package com.github.budwing.pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

	public void update(Observable o, Object arg) {
		System.out.println("Teacher receive "+arg);
	}
	
}
