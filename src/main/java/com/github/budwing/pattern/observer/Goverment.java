package com.github.budwing.pattern.observer;

public class Goverment implements Observer {

	public void receiveMsg(String msg) {
		System.out.println("Goverment receive "+msg);
	}

}
