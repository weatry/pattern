package com.github.budwing.pattern.observer;

public class Student implements Observer {
	public void receiveMsg(String msg) {
		System.out.println("Student receive "+msg);
	}
}
