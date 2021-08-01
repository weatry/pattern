package com.github.budwing.pattern.composite;

public class Demo {

	public static void main(String[] args) {
		Fan fan = new Fan();
		Mainboard mb = new Mainboard();
		Cpu cpu = new Cpu();
		mb.add(cpu);
		mb.add(fan);
		cpu.add(fan);
	}

}
