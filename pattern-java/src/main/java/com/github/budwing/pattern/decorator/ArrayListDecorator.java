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

class ArrayListDec2 extends ArrayList {
	private ArrayList list;

	public ArrayListDec2(ArrayList list) {
		this.list = list;
	}

	public boolean add(Object arg0) {

		boolean b = list.add(arg0);
		System.out.println("finish add");
		return b;
	}
}
