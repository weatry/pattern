package com.github.budwing.pattern.observer;

public class Demo {

	public static void main(String[] args) {
		School s = new School();
		s.addObserver(new Student());
		s.addObserver(new Teacher());
		s.addObserver(new Goverment());
		
		s.publishMsg("some message");
	}

}
