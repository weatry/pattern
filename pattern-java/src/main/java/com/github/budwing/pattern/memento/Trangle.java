package com.github.budwing.pattern.memento;

public class Trangle {
	private int a;
	private int b;
	private int c;

	public Trangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public TrangleMemento getState() {
		return new TrangleMemento(a, b, c);
	}
	
	public void restoreState(TrangleMemento memento) {
		a = memento.getA();
		b = memento.getB();
		c = memento.getC();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}
