package com.github.budwing.pattern.state;

public class Pupa implements ButterFlyState {

	public void eat() {
		System.out.println("我是蛹，我不吃东西！");
	}

	public void fly() {
		System.out.println("我是蛹，我不能飞！");
	}

	public void walk() {
		System.out.println("我是蛹，我不能动！");
	}

}
