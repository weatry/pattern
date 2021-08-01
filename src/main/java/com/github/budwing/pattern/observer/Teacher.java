package com.github.budwing.pattern.observer;

public class Teacher implements Observer {
	public void receiveMsg(String msg) {
		System.out.println("Teacher receive "+msg);
	}
}
