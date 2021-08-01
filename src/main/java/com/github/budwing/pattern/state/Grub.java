package com.github.budwing.pattern.state;

public class Grub implements ButterFlyState {

	public void eat() {
		System.out.println("我是幼虫，我吃青菜！");
	}

	public void fly() {
		System.out.println("我是幼虫，我不能飞！");
	}

	public void walk() {
		System.out.println("我是幼虫，我只能爬！");
	}

}
