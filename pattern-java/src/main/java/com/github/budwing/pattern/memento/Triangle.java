package com.github.budwing.pattern.memento;

public class Triangle {
	private int a;
	private int b;
	private int c;

	public Triangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public TriangleMemento getState() {
		return new TriangleMemento(a, b, c);
	}

	public void restoreState(TriangleMemento memento) {
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
