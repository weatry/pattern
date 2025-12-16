package com.github.budwing.pattern.bridge;

public class GSMNet extends Net {

	public void sendMsg() {
		System.out.println("process gsm signal");
		signal.encoding();
		System.out.println("gsm send msg!");
	}

}
