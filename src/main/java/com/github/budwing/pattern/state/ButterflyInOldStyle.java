package com.github.budwing.pattern.state;

public class ButterflyInOldStyle {
	private String state = "grub";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void walk() {
		if ("grub".equals(state)) {
			System.out.println("我是幼虫，我只能爬！");
		} else {
			System.out.println("我是成虫，我能走了！");
		}
	}

	public void fly() {
		if ("grub".equals(state)) {
			System.out.println("我是幼虫，我不能飞！");
		} else {
			System.out.println("我是成虫，我可以飞！");
		}
	}

	public void eat() {
		if ("grub".equals(state)) {
			System.out.println("我是幼虫，我吃青菜！");
		} else {
			System.out.println("我是成虫，我采蜜！");
		}
	}
}
