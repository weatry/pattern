package com.github.budwing.pattern.decorator;

import java.util.ArrayList;

public class ArrayListDecorator extends ArrayList {

	private ArrayList list;
	
	public ArrayListDecorator(ArrayList list) {
		this.list = list;
	}
	
	public boolean add(Object arg0) {
		System.out.println("in add");
		return list.add(arg0);
	}

}
