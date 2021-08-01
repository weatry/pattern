package com.github.budwing.pattern.memento;

public class Demo {

	public static void main(String[] args) {
		Trangle t = new Trangle(34, 35, 35);
		TrangleMemento tm = t.getState();
		
		t.setA(23);
		t.setB(12);
		t.setC(1);
		
		t.restoreState(tm);
	}

}
