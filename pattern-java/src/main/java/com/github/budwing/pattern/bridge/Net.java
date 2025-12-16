package com.github.budwing.pattern.bridge;

public abstract class Net {
	protected Signal signal;
	
	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	public abstract void sendMsg();
}
