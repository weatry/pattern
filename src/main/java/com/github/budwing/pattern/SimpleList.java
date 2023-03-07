package com.github.budwing.pattern;

/**
 * An example of list
 */
public class SimpleList {
	protected int length;
	public void add(int i, Object obj) {
		System.out.printf("add an object:%s\n", obj);
		length++;
	}
	
	public Object remove(int i) {
		System.out.printf("remove No. %d element", i);
		length--;
		return "something";
	}
}
