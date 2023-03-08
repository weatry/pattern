package com.github.budwing.pattern.decorator;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList d1 = new ArrayListDecorator(list);
		ArrayList d2 = new ArrayListDec2(d1);
		
		d2.add("dd");
		System.out.println(list.get(0));
	}

}
