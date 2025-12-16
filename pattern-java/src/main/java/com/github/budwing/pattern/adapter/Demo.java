package com.github.budwing.pattern.adapter;

import java.util.Enumeration;

public class Demo {

	public static void main(String[] args) {
		OldSystem oldSys = new OldSystem();
		NewSystem newSys = new NewSystem();
		Enumeration e = oldSys.data();
		EnumList el = new EnumList(e);
		newSys.process(el);
	}

}
