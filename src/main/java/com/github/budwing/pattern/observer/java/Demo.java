package com.github.budwing.pattern.observer.java;

public class Demo {

	public static void main(String[] args) {
		School s = new School();
		s.addObserver(new Student());
		s.addObserver(new Teacher());
		s.addObserver(new Goverment());
		s.setChanged();
		s.notifyObservers("sfsd");
		s.setChanged();
		s.notifyObservers();
	}

}
