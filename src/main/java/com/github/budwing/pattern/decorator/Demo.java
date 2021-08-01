package com.github.budwing.pattern.decorator;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList d = new ArrayListDecorator(list);
		
		d.add("dd");
		System.out.println(list.get(0));
	}

}
