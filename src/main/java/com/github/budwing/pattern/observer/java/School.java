package com.github.budwing.pattern.observer.java;

import java.util.Observable;

public class School extends Observable {

	public synchronized void setChanged() {
		super.setChanged();
	}
	
	
}
