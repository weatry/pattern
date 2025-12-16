package com.github.budwing.pattern.command;

public class Fan {
	public void start() {
		System.out.println("Fan start!");
	}
	public void stop() {
		System.out.println("Fan stop!");
	}
	public void speedup() {
		System.out.println("Fan speed up!");
	}
	public void slowdown() {
		System.out.println("Fan slow down!");
	}
}
