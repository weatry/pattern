package com.github.budwing.pattern.state;

public class Imago implements ButterFlyState {

	public void eat() {
		System.out.println("我是成虫，我吃蜜！");
	}

	public void fly() {
		System.out.println("我是成虫，我能飞！");
	}

	public void walk() {
		System.out.println("我是成虫，我能走！");
	}

}
