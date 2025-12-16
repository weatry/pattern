package com.github.budwing.pattern.observer;

public class Parent implements Observer {

	public void receiveMsg(String msg) {
		System.out.println("Parents receive "+msg);
	}

}
