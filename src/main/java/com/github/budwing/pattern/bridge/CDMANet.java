package com.github.budwing.pattern.bridge;

public class CDMANet extends Net {

	public void sendMsg() {
		System.out.println("process cdma signal");
		signal.encoding();
		System.out.println("cdma send msg!");
	}

}
