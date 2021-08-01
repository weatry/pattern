package com.github.budwing.pattern.bridge;

public class Demo {

	public static void main(String[] args) {
		Net net = new CDMANet();
		net.setSignal(new VideoSignal());
		net.sendMsg();
	}

}
