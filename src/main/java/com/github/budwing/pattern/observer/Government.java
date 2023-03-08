package com.github.budwing.pattern.observer;

public class Government implements Observer {

	public void receiveMsg(String msg) {
		System.out.println("Government receive "+msg);
	}

}
