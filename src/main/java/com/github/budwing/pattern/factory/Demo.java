package com.github.budwing.pattern.factory;

public class Demo {

	public static void main(String[] args) {
		ComputerFactory factory = new DeskFactory();
		CPU cpu = factory.createCPU();
		Memery m = factory.createMemery();
		HardDisk hd = factory.createHardDisk();
	}

}
