package com.github.budwing.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class School {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void publishMsg(String msg) {
		for(Observer o:observers) {
			o.receiveMsg(msg);
		}
	}
}
