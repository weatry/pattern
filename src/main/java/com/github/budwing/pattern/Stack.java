package com.github.budwing.pattern;

public class Stack {
	
	private List list = new List();
	
	public void push(Object obj) {
		list.add(list.length, obj);
	}
	
	public void pop() {
		list.remove(list.length);
	}
}
